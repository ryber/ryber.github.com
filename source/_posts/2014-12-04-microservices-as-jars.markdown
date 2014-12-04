---
layout: post
title: "Microservices as Jars"
date: 2014-12-04 06:30
comments: true
categories:
---

A couple of months ago Uncle Bob Matrin wrote about <a href="http://blog.cleancoder.com/uncle-bob/2014/09/19/MicroServicesAndJars.html">microservices as jars</a> (or gems or dlls etc). I’ve been harboring the same idea for a while so I was encouraged to see him talking about it. I’ve also seen both positive and downright hostile responses to him. I’ve been honing in on a way to do this and I think I see where the hostility comes from.

<img src="/assets/images/Kim_Cheese.jpg" align="right" /> You see there are two rules about microservices. 1) They need to be isolated and 2) They need to be more isolated than that. In fact they need to be Kim Jong-un isolated. When you run a microservice as it’s own deployable behind it’s own REST interface then it’s easy. You can use whatever libraries, languages, even operating systems you want. However, when deploying a jar inside of another application you are suddenly no longer free. The runtime will demand only one version of your orgs favorite MVC for example, and everyone better be on the same page.

So when crafting a jar you need to be dependent on as little as possible. I personally find freedom from frameworks liberating. Besides it’s a “MICRO” service, you don’t need an IOC framework or an ORM at all. In practice I can see many organizations having problems with this, Green developers like glueing frameworks together. Things like Spring make it look like it would be easy to just add yet another jar into the component scan. You need to stop! Because that leads to the dark side….dependency, coupling, and weeks spent upgrading 20 jars at once to Spring 4.1.X when just one of them needs to go.

I know Uncle Bob knows all this already. I’m not sure he emphasized it enough or appreciates how many people will attempt to implement his idea in completely wrong ways.

But I’m going to do it anyway.
