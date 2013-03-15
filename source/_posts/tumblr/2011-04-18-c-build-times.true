--- 
title: C# Build Times
layout: post
tags: c#
---
<p>Today a friend was expressing concern about C# test loop times. Even going so far as comparing it to <em>gasp</em> C++</p>

<p>He challenged me to &#8221; please see if you can get a smallish project, maybe 1K unit tests (ignore other tests) to build and run in &lt;45s &amp; blog it!!&#8221;</p>

<p>Well, lately I&#8217;ve been working on setting up a integration test suite for Ninject, so I was familiar with it as not just a small, fast C# library, But one that is quite popular.</p>

<p>So here is the result. For just the build/test of the core project total time from the command line is between 4-5 seconds. 2 of that is running the 223 unit and integration tests.</p>

<p><img src="/assets/images/tumblr_ljvimpibdW1qhdwsd.png" alt=""/></p>

<p>For a total CI package/build including generating packages for .Net 2.0, 3.5, 4.0, 3.5 compact, and silverlight 2, 3 and 4 which adds up to 669 tests takes around 1:45 - 2 minutes.</p>

<p>So I&#8217;d say that shows that .net is at least capable of having fast cycle times. The thing that&#8217;s still missing are good autotest tools. IntelliJ and Eclipse smoke VS in terms of testing and refactoring. ReSharper&#8230;as good as it is&#8230;does nothing for the rest of the bloat in studio.</p>

<p>Now, if only we could get JetBrains to make a ReSharper for MonoDevelop we would be all set.</p>
