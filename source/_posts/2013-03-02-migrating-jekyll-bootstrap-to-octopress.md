---
layout: post
title: "Migrating Jekyll Bootstrap to Octopress"
date: 2013-03-15 11:29
comments: true
categories: 
---

Even though Octopres uses Jekyll for generating pages it's layout and the way they expect you to use it with Github Pages is actually quite different. This is my recipe for migrating:

### Layout Overview

Now with Jekyll-Bootstrap your directory structure probably looks something like this:

``` 
Hal9000:ryber.github.com ryber$ ls
404.html	_includes	archive.html	changelog.md	sitemap.txt
README.md	_layouts	assets		index.md	tags.html
Rakefile	_plugins	atom.xml	pages.html
_config.yml	_posts		categories.html	rss.xml
```

Your site and the Jekyll code are interwoven. You probably have it all on one branch, and when you push you push the entire thing.

This is not the case with the standard Octopress layout. It looks more like this:


```
Hal9000:ryber.github.com ryber$ ls
CHANGELOG.markdown	_config.yml		public
Gemfile			  	_deploy			sass
config.rb		    source
README.markdown		config.ru
Rakefile			plugins
```

Everything you see here with the exception of the ```_deploy``` folder (which is listed in the ```.gitignore``` will be kept on a ```source``` branch in git. The contents of the ```_deploy``` folder will be your production branch. Almost all of your work will go into the ```source``` folder. 

In order to get to the right state we are going to be a little sneaky as we move things around.

## Pre-reqs
You will need at least version 1.9.3 of ruby. If you don't have it yet I suggest [installing RVM](https://rvm.io/rvm/install/). 

After installing make sure you have 1.9.3 like this:

```
rvm install 1.9.3
rvm use 1.9.3
rvm rubygems latest
```

## The old switcheroo
OK, so what we need to do now in order to get everything into the right place is to move the "main" directory into a branch and keep the master in a subdirectory.

So first make a backup copy of our current state. and then go into the original.
```
cp -r ryber.github.com/ old.ryber.github.com
cd ryber.github.com
```

next we need to make a ```source``` branch where our Jekyll is going to live. After doing that delete all of the content from the branch.

```
git checkout -b source
Switched to a new branch 'source'

git rm -r *
git commit -m "clearned out everything from branch"
```

Next we are going to get the octopress content and copy it into our directory without the git history.

```
cd ..
git clone https://github.com/imathis/octopress.git octopress
cd octopress
git archive master | tar -x -C ../ryber.github.com 
cd ../ryber.github.com
git add . 
git commit -m "added octopress content"
```

Now lets make sure we have a working octopress directory. When you CD'd into the dir rvm probably asked you if you want to trust the rvmc file. Do so. Now set up the app:

```
gem install bundler
rbenv rehash    # If you use rbenv, rehash to be able to run the bundle command
bundle install
rake install
```

Now we are going to clone your original master branch into the ```_deploy``` dir. Yes this is kind of weird. The outer directory will be on the ```source``` branch and the ```_deploy``` dir will be on the ```master``` branch.

```
git clone https://github.com/ryber/ryber.github.com.git _deploy
```

## Migrating content

This is the hard part. Copy your content over from the ```/_deploy``` directory to the ```/source``` directory. This is not going to be an exact science. Take a look at what you've got and migrate as neccessary. Your milage may vary.

You can probably get 90% of what you need with these two:
```
cp _deploy/_posts source/posts
cp _deploy/assets source/assets
```

## The _config.yml file

The two config files are a bit different. You can't just copy the boostrap file over so open them both and copy the individual settings over that you need.

## Preview
Run the site and check it out. Make sure everything is what you want it to be. When you do a ```preview``` Jekyll will place your files in the ```public``` directory (which is also ignored by git)

```
rake preview
```

## Final Steps

Now we are going to replace your old site with the new site (at last!)

We need to clear out all of the files on the master branch to make way for the new content.

```
cd _deploy
git rm -r *
git commit -m "cleaning house"
cd ..
rake deploy
```
 When you do the deploy it's going to:
 
* generate the site and place the contents into the ```_deploy``` directory (your master branch)
* add and commit everything present to git's origin master.
* push the master branch to github.

Last don't forget to push your source branch to github!

```
git push origin source
```













