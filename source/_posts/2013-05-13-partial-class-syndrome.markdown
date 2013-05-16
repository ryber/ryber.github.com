---
layout: post
title: "Partial Class Syndrome"
date: 2013-05-13 20:07
comments: true
categories: code
---

The other day I ran into a smelly code scenario. Not only was it smelly, it was eerily familiar. I've run into this several times in this particular codebase and I finally put a name on it. "Partial Class Syndrome".

Now anyone familiar with C# knows that you can split one class over several different files by using the <a href="http://msdn.microsoft.com/en-us/library/wa80x488(v=vs.80).aspx" >partial</a> keyword. It's really a pretty horrible thing to do there is a very very limited scope for it being a good idea. Generated code like web service stubs are often partial so you can add to them without extending them. Other than that partials are super crappy. They make code hard to read and understand and they encourage classes to get way too big. In fact a partial sometimes shows up in code when a class gets so big that people want a quick and dirty way to make it *look* smaller.

<img src="http://upload.wikimedia.org/wikipedia/en/b/b8/Three_Stooges_Intro_Card_1936.jpg" alt="The Boys" />

Anyway this project is Java and so can't do partials. At least you would hope not. Yet there I was looking at three classes. We can call them Larry, Moe and Curly. These three were all basically the same class with some different methods. They had the same dependencies, they took and returned the same classes, did similar things and even had similar names. On top of that they were all held by a big model class that used them interchangeably calling one and passing it's data into the others. 

So here I was working in Moe and finding that I needed the functionality of Curly. I was also getting confused about which class did what due to the similarity.

The "fix" of course was to:

1) Merge them together. This resulted in a pretty huge class which I was uncomfortable with but at least it solved the ambiguous confusion.

2) Simplify the model's use of the code to just let the new big class handle the back and forth with it's own methods. This actually resulted in a lot of methods being removed or made private.

3) Extract smaller specialty classes that deal with unique things. I'm still doing this step. This is always the hard part but if you look carefully you can find the classes hidden in there. Pay particular attention to feature envy.

I ended up with a single class that is smaller than the three from before and something that's easier to read and understand. It’s still too big for my taste but It’s better than what was there before...at least for now.

