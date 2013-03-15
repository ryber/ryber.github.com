--- 
title: The Big Book Of Dead Code
layout: post
tags: undead
---
<p>Several years ago I became the inheritor of a rather large codebase that had been farmed out to an R&amp;D team of contractors. I could go on with a litany of grievances about the delivered product but I&#8217;ll leave most of those for other posts. Todays issue is about dead code. When we got the application it was quite bloated with unfinished and forgotten features. Imagine going to look into a bug only to find that there are 3 different modules that do the same thing; only one of which was actually used. There were entire assemblies that did nothing, or very little. Lots of modules were &#8220;flexible&#8221; but then configured to just work one (very simple) way.</p>

<p>How it got this way could be a good masters thesis on the dangers of waterfall and cramming every possible requirement into a bloated spec at the begining, but regardless of that, the team had a problem.</p>

<p>Extra and unnecessary code made building slow, made performance slow, and made testing slow and very difficult. It was confusing for developers to to have to deal with and it wasted all kinds of time with rabbit holes and marathon sessions in the debugger. Worst of all there were few tests to document the behavior.</p>

<p>Finally after a particularly difficult weekend the team had had enough. We made some time, got out the machete and started to hack away at the dead flesh. The result was a faster, less confusing, less buggy system that performed all of the same duties as the original app. Dev velocity went up as build times and time in the debugger went down. Occasionally there would be second guessing, &#8220;What if we need that some day?&#8221;, &#8220;Well, that way IS more flexible&#8221;, but you know what? That&#8217;s what version control is for. To this day I have yet to go hunting back in time looking for some of that dead code.</p>

<p>The other result was legend&#8230;&#8221;The Big Book of Dead Code&#8221;. The more and more code I hacked away the angrier I got. I watched as developers I knew from the R&amp;D team disappeared like they had never existed. It was never their fault that they were asked to write something the product never needed to begin with.</p>

<p><img src="/assets/images/tumblr_ljwfsjJT9O1qhdwsd.jpg" alt=""/></p>

<p>We needed to be able to show to management how much waste a gigantic 2 year waterfall project produced. So I took the diffs and wrote a little script (called &#8220;Bring Out Yer Dead&#8221;) that took the deleted code, removed all of the spaces, tabs and line breaks, formatted everything into a sigle block of raw text and then printed it all out in a 9pt font front and back. As the code was removed the book grew.</p>

<p><img src="/assets/images/tumblr_ljwft3bUOZ1qhdwsd.jpg" alt=""/></p>

<p>It ended up being easily over 500 pages. 500 pages of blood, sweat, yak hair and money. The book became famous, people would come from far and wide to gaze in wonder. I never saw the look on the owners faces when they were shown it, but I was told that it was very sobering. It ended up becoming a symbol of development black holes. Never again would management tolerate non-incremental development and gold plated specs. We would deliver small bits quickly, we would adjust requirements as needed. We would do only what needed to be done. Keep it simple! Yagni! &#8220;Bring out Yer Dead!&#8221;</p>

<p><img src="/assets/images/tumblr_ljwftmvV0B1qhdwsd.jpg" alt=""/></p>
