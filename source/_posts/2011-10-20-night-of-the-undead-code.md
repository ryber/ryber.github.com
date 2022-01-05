--- 
title: Night of the Undead Code
layout: post
tags: undead
---
<p>I’ve <a href="http://ryber.tumblr.com/2011/04/19/the-big-book-of-dead-code">written before about dead code</a> and how it can gunk up you system, slow you down, and cause all kinds of problems. So with Halloween on its way I wanted to muse on something even worse than dead code&#8230;.undead code. You see most of the code you end up killing in a dead code hunt is not dead yet, its only mostly dead. You have to find out if it’s really holding on for true love or planning on eating your face. So how do you tell? Lets find out.</p>

<p><strong>Dead-Parrot Dead</strong>: This is the easy stuff. The class or method that is never invoked. The library that’s only imported but never used. This kind of code is easy to remove, it’s very low risk. Don’t listen to the people who tell you that the code is just resting or stunned. It’s kicked the bucket, shuffled off it’s mortal coil, run down the curtain and joined the bleedin&#8217; choir invisibile!! THIS IS EX-CODE!! Clean up the body.  Kill Satisfaction: <em>1 Zombie head</em></p>

<p><img src="/assets/images/tumblr_lte7e4nuW21qhdwsd.jpg" alt=""/></p>

<p><strong>Ghost Code</strong>: Ghost code is actually the most common. You probably have it all over your code base and you don’t even know it.  I’ve known developers who have spent their entire careers on projects writing code nobody asked for. Unless you can tie code to a specific business case and it’s bringing value right now (NOT “maybe someday”) then all it’s doing is getting in the way and sucking away your time. Exorcise it now and put it out of it’s misery. Kill Satisfaction: <em>3 Zombie Heads</em></p>

<p><strong>Zombie Code</strong>: A more subtle form of dead code is zombie code. Code that looks alive but actually wants to eat your brain. This is code that is unreachable due to various reasons.  Perhaps its related to a particular entry in a config file that never has a different value. It can also be spotted by a tell tale magic bool being passed to a method which is only ever called with “true” or “false”. At worst the code  is strung throughout complex classes and methods that are only used in one particular way with limited expectations. If a developer ever tells you his code is “flexible” be wary, it might be a zombie.</p>

<p>These kind of scenarios can be a little harder to dig out, but often have a single kill point. Once you shoot it in the head it leads to an avalanche of deleted code. <em>Kill Satisfaction: 6 heads.</em></p>

<p><strong>Vampire Frameworks</strong>: <img src="/assets/images/tumblr_lte6ts4mYD1qhdwsd.jpg" align="right"/> Frameworks are pretty, they solve all of your problems and their perfect 19 year old bodies sparkle while they seduce you with their smoldering eyes. Don&#8217;t be fooled though! Any frameworks that forces you to generate boilerplate after boilerplate that you don&#8217;t find useful (or understand) is pure eeeevil. Even worse are the ones that generate these boilerplate classes themselves and inject their unholy poison all over your app. They suck away your flexibility, your ability to test and your ability to be lightweight. They often are quite good at doing something the way they think you should do it but as soon as you need to do something different (about day 3 in) they make your life a living hell.</p>

<p>Once established, killing off a framework can be quite hard. You need to stop them as early as possible. Kill Satisfaction: 10 heads.</p>
