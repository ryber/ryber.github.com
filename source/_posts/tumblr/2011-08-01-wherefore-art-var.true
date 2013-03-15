--- 
title: Wherefore art var?
layout: post
tags: java
---
<p>To expand on my little rant about Java 7 let me rant about the one feature that almost all other modern languages have that Java lacks and really bugs me.</p>

<p>var</p>

<p>Yes, var, it seems like such a little thing, such a minor feature, but it makes refactoring so much easier. Take this statement:</p>

<pre><code>  var foo = someObj.GetFoo();
</code></pre>

<p>Note how nowhere in this statement does it explicitly say what foo is. It’s still statically typed because the compiler can infer type from GetFoo’s return. Some people might think that’s a problem but we have modern IDE’s so it’s really no big deal.</p>

<p>The power comes when I want to refactor GetFoo, now as long as whatever it returns has the same signature as the original everything is OK and I never have to touch this file. I might be introducing a interface, or a abstract class or even completely replacing it with some other implementation. It matters not, all that matters is that my change had the smallest impact possible.</p>

<p>In Java 7 they are introducing some generics stuff where you don’t have to state the type twice. So instead of</p>

<pre><code>   Map&lt;String,String&gt; foo = new Map&lt;string,string&gt;();
</code></pre>

<p>you can do</p>

<pre><code>  Map&lt;String,String&gt; foo = new Map&lt;&gt;();
</code></pre>

<p>This completely misses the point of type inference. All it does is save me some keystokes but it does little to assist future refactorings. The fact that Sun/Oracle spent time on this rather than proper inference features is mind boggling and almost insulting.</p>

<p>P.S. <a href="http://projectlombok.org/features/val.html">someone has made a library to attempt this</a>. I can’t speak for how well it works or it’s impact as I have not yet used it. I suspect that for type inference to really work well it needs to be baked into the compiler.</p>
