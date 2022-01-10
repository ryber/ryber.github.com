--- 
title: 6 Simple Rules For Handling Collections.
layout: post
tags: xp
---
<p>Simple rules for handling collections. This applies mostly to static languages like C# and Java:</p>

<ol>
<li>Always use generics if you can. Especially in C# where there are major performance advantages.</li>

<li>Methods should always accept the simplest abstraction of a collection as possible. Iterable<t> in java, IEnumerable<t> in C#. This gives classes using the method the most flexibility. If you don’t need it to be a list, don’t ask for one.</t></t></li>

<li>When returning a list return the most fully functioning implementation you can (without going out of your way&#8230;.this is a very loose rule).</li>

<li>When returning collections; if you don’t want people to modify the list then return a Immutable/Readonly list&#8230;and let them know it. Don’t hide a Immutable list behind simple interfaces.</li>

<li>If the collection you return gets passed around a lot, think about making it into a little class. This can either be a wrapper or just extending a collection type. This will let you tweek the implementation and show intent better.</li>

<li>If #5 is applying to a hashtable, dictionary or map have an even lower tolerance for when you make it a class. I almost never expose a map publicly.</li>
</ol>