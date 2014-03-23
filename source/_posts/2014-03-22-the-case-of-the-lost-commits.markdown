---
layout: post
title: "The Case Of The Lost Commits"
date: 2014-03-22 17:16
comments: true
categories:
---
Recently at my gig we converted a large project from HG to Git. There are a lot of developers on this project; many who have never worked on Git so I expected a few bumps. So far it’s actually been pretty smooth sailing but yesterday I was contacted by a dev with a Git problem I had never seen.

The day before he had made a commit and pushed it to the server but now the content of the commit was gone. Not reverted mind you, just gone, like it had never happened even though the commit was clearly still in history.

To be clear, looking at the history of the entire repo showed the commit and it’s changes as something that happened. But looking at any of the individual files in the commits didn’t show the commit at all. WTF?!

This turned out to be the result of a bad merge by another developer. I was able to recreate the scenario, take a look at the weird history:

    ryber$ git log --graph --oneline --all
    *   1b4cd92 Bad merge by dev B
    |\  
    | * e879eb6 This is the missing commit by dev A
    * | 93933b9 commit by dev B
    |/  
    * 6baed99 root commit

Here we can see that e879eb6 is in history. You can see that part of that commit was a change to foo:

    ryber$ git whatchanged e879eb6
    commit e879eb6007ddef2a955a71651bcf31a25727b510
    Author: ryber
    Date:   Sat Mar 22 16:37:28 2014 -0500

        This is the missing commit by dev A

    :100644 100644 eb314de... e3525a0... M  baz
    :100644 100644 ae3cab0... cf561bd... M  foo

Yet, if we look at the history of foo that e879eb6 is missing!

    ryber$ git log --pretty=oneline --abbrev-commit -- foo
    6baed99 root commit

What happened here? Where did e879eb6 go in the history of foo? I can understand if the change was reverted but shouldn't we see some history of that revert? This is where we get into the bad merge

You may have notice that the missing commit includes another change to the “baz” file. It turns out that the second dev also changed baz in 93933b9 and was forced to go into a merge conflict when he pulled. To someone new to git the merge process might be a bit shocking. This is because you see all of the changes impacted by the merge. This includes your own changes as well as all of the changes to files in the tree you are merging in that happened after your last common ancestor. Developer B was presented with something like this when he was merging:

    ryber$ git status
    On branch master
    Your branch and 'origin/master' have diverged,
    and have 1 and 1 different commit each, respectively.
      (use "git pull" to merge the remote branch into yours)

    You have unmerged paths.
      (fix conflicts and run "git commit")

    Changes to be committed:

    	modified:   foo

    Unmerged paths:
      (use "git add <file>..." to mark resolution)

    	both modified:      baz

You might think “What the hell? I didn’t change foo?! Why is foo here?”. You might even attempt to get rid of the foo changes … which is exactly what happened. It’s actually kind of hard to do from the shell but fairly easy to do from some gui tools like SourceTree. From the shell you just have to issue a checkout of a previous version like this:

    ryber$ git checkout HEAD^ -- foo

Then an add, and a commit and voilà! The file has now been reverted to it’s previous state as part of a merge and it’s individual content history no longer contains the missing commit.

You may be wondering how we got out of this mess? We simply cherry-picked the commits back into the head. Not very subtle but it worked.

    ryber$ git cherry-pick e879eb6
