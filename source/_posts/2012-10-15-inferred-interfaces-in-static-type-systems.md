--- 
title: Inferred Interfaces in Static Type Systems
layout: post
tags: 
- java
- c#
---
<p>One of the primary criticisms of static languages is that they require needless levels of boilerplate. This can be painfully true, and any C# or Java developer can most likely point to a weird workaround they had to do to use some sealed/final Spring or .Net class. Eventually most large projects become littered with wrappers and adapters and mappers to get objects to “fit” inside the rigid static typing system. But why does the type system have to be so inflexible?</p>

<p>I’ve had an idea for some time that goes something like this. Lets say you have this C# method:</p>

<pre><code>public void DoSomething(HttpRequest request){
request.Params ...
}
</code></pre>

<p>Oh Noes! the dreaded HttpRequest class. So full of sealed horribleness; and all we want is the stupid Params. If I want to be able to test this I can either go through the annoyingly complex process of building a HttpRequest object or I can try and swap out HttpRequest for Microsofts wrapper abstraction (or my own). None of that is nice and in the end I will have a bunch of code I don’t need or want.</p>

<p>Wouldn’t it be great if I could just add a interface to HttpRequest? It would solve most of my problems. It would be mockable and could define just the parts I need. Unfortunately I can’t break into Redmond and add an interface to that class.</p>

<p>But why not? Compilers are fast and smart and can figure out all kinds of things. Let say I made this interface for my method:</p>

<pre><code> public interface IHttpRequest { Params {get;set;}}
</code></pre>

<p>I don’t see any reason the compiler (and IDE’s) could not look at the requested interface, look at HttpRequest and say “yep, that works.” It would STILL be type safe. It would STILL happen at compile time. It would NOT require anything to happen at runtime, and it would NOT be the same as duck typing because the object could not be just anything that (might) fulfill the request at runtime. The compiler would simply make a shorthand reference the first time it sees that HttpRequest implements IHttpRequest in the context of the package/assembly.</p>

<p>Maybe for speed there would have to be some kind of keyword on the interface or the param? Maybe not. Hey Anders or whoever is in charge at Oracle&#8230;give me a call, we can work it out.</p>

<p>Can anyone verify if there are static languages that do this? I have a hunch that Scala’s “traits” are somewhat like this but I’m not sure.</p>
