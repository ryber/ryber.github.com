---
layout: post
title: "Trolling Technology"
date: 2014-10-21 19:26
comments: true
categories:
---

I've been upgrading frameworks in a number of projects lately and I felt the need to rant about frameworks I really dislike.

### HAML
<img src="/assets/images/hipster_cat.jpg" align="right" /> Several years ago some hipster programmers were frustrated by HTML. Since dogs and babies were qualified to write HTML they weren't able to let everyone else know how awesome they were on 100% of a project. So they invented HAML to protect their smartypants status.

The main battle cry of HAML seems to be that you can write HTML “faster”. As if writing HTML was the bottleneck of programming. If your main bottleneck is writing HTML then either you are the the most awesome programmer on the face of the planet and you need to quit writing web sites and start finding a cure for ebola or you don’t work on anything remotely difficult (lucky you). Thankfully [every](https://docs.oseems.com/general/application/vim/auto-complete-html) [text editor](http://web-mode.org/) [on earth](https://www.sublimetext.com/docs/2/auto_complete.html) [autocompletes](http://superuser.com/questions/131542/html-tag-auto-complete-in-notepad) [HTML](http://www.barebones.com/support/bbedit/arch_bbedit9.html). Which means HAML is a problem disguised as a solution to a problem that doesn’t exist.

(note that I don’t feel the same about SAAS or LESS which at least help to fix some of the major problems with the W3C’s [biggest failure](https://infrequently.org/2007/09/css-3-a-giant-serving-of-fail/): CSS)

### ORM's
Hibernate, Rails, iBatis, whatever. ORMs do two things: 1) Save you from writing a bunch of mundane crap early in a project and 2) Guarantee you will spend oodles of time trying to debug a labyrinthian hellhole later in the project. This is the root of what I like to call the the "Law Of Frameworks" which states

```
Any framework designed to keep you from
thinking about a thing will force you to
have to think about that thing in more
difficult ways than if you had not used it.
```

I've seen team after team, project after project waste weeks to months fighting ORM's. Stop the madness!

### YAML
See HAML. Use JSON.

### Apache HttpClient (any version)
Try to think of the most convoluted and stupid way to make a web request. Then make it dumber than that and require at least eight classes to do it. This is HttpClient. This is why people hate Java.

### AOP
There is nothing worse than a method suddenly working differently in your production code than it does in tests. This is what AOP does. Making it the antithesis of the [Principle of least astonishment](http://en.wikipedia.org/wiki/Principle_of_least_astonishment). ORM’s often make use of AOP which should be a sign. As does the last item.

### Spring
Spring is the most cargo-culted software framework in the world. Almost nobody understands the entire thing. At best people learn a small bit for a little while. Then they leave it alone for 6 months and forget. The framework itself it a giant magical mudball that configures itself with annotations and XML (yes I know about the Java configs but those are not 100%, nor are they really much better). Almost nothing is obvious or simple.   StackOverflow is [littered](http://stackoverflow.com/questions/18022571/aspect-tag-on-spring-is-not-recognized) with questions about [completely obscure](http://stackoverflow.com/questions/26281715/is-spring-startup-impacted-by-order-on-disk), [unhelpful](http://stackoverflow.com/questions/3896013/no-adapter-for-handler-exception/3896018), and [downright weird](http://stackoverflow.com/questions/1468657/spring-weird-error-in-bean-creation) errors. The answers (if they have one) are often something along the lines of “oh you forgot to implement and register the AbstractSingletonProxyFactoryBean (which is a Convenient proxy factory bean superclass for proxy factory beans that create only singletons of course)”. The answer almost never explains what the hell any of this means. Just worship the coke bottle correctly and the bean will show up with candy on the spring equinox!

If ever you choose to upgrade Spring you will find that half the classes you used before have been replaced by other classes that don’t do the same things.

This is the other reason people hate Java.
