---
layout: post
title: "Developers In Wonderland"
date: 2015-02-22 12:12
comments: true
categories:
---
Last week I posted a fun little troll of Java on the Twitters and it kind of blew up.

<blockquote class="twitter-tweet" lang="en"><p>Everyone enjoys trolling JavaScript for it&#39;s weirdness but everyone has something. Here&#39;s Java <a href="http://t.co/SszNlbefLP">pic.twitter.com/SszNlbefLP</a></p>&mdash; Ryan Bergman (@ryber) <a href="https://twitter.com/ryber/status/567681894662164480">February 17, 2015</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>

What I got in response (besides the retweets and favs) was a lot of people who felt the need to inform me of why each line was the way it was (and in some cases how stupid I was for not knowing it). I started to experience a phenomenon that is quite common amongst software developers that I like to call “Wonderland Syndrome”.

<blockquote style="font-size:110%">
“But I don’t want to go among mad people," Alice remarked.<br/>
"Oh, you can’t help that," said the Cat: "we’re all mad here. I’m mad. You’re mad."<br/>
"How do you know I’m mad?" said Alice.<br/>
"You must be," said the Cat, "or you wouldn’t have come here.”<br/>
― Lewis Carroll, Alice in Wonderland<br/>
</blockquote>

Apart from Alice and the Cheshire Cat nobody in Wonderland knew that they were mad. This attitude, to simply accept the rules a system has given to you whether they are logical and good or not is actually a strength in computer programming. In a <a href="http://www.eis.mdx.ac.uk/research/PhDArea/saeed/paper1.pdf">paper from Middlesex University</a> it was found that successful CS majors were better able to accept and understand the sometimes odd rules of computers.

<blockquote style="font-size:110%">
“To write a computer program you have to come to terms with this, to accept that whatever you might want the program to mean, the machine will blindly follow its meaningless rules and come to some meaningless conclusion”
</blockquote>

 It's also why we all love puns so much. The problem comes when this understanding moves into an orthodoxy around how it should be. None of the examples in the tweet show this more than the response to the last item. Some people seemed incensed that I apparently didn’t understand that prefixing a number with 0 indicated an octal number and that this is how it was in C and many other languages. <a href="https://www.gnu.org/fun/jokes/ed-msg.html">"0 is the standard!"</a>

0 is a horrible thing to use to indicate octal. My 3rd grader can tell you that leading zeros are not significant and so <code>022 - 2 = 20</code>. Why must we surprise everyone with something different? Maybe 43 years ago when C was being created on PDP-8s with 12 bit words it was the only thing to do. I tend to think that even then anything else would have been better.

Fast forward to 1995 and Java had no reason at all to continue with it. I believe they did so simply because of Wonderland Syndrome. "Of course octals start with 0, and hedgehogs make perfect croquet balls."

Yet here we are, running caucus-races to get dry and fixing bugs because of the limitations of a 43 year old computer. THAT my friends, is the WTF.

-------------

I should note that most modern languages are moving away from 0 for octal. C#, Python 3, ECMAScript 5, etc. Alas, it is probably too late for Java as changing it might break the .0000001% of programs that did it on purpose.
