---
layout: post
title: "Staying DRY with Mocking Frameworks"
date: 2022-01-23 11:07
comments: true
categories: 
---

<img src="/images/800px-Alice_par_John_Tenniel_34.png" align="right" alt="Mock Turtle" hspace="10" vspace="10" width=300 />

Let me start by saying that I don’t hate mocking frameworks. They can be incredibly useful, and from an intellectual standpoint they’re some of the most amazing and interesting code you can look at. If you want a masters class on reflection and runtime manipulation go dig around in them. 

What I do dislike is how they’re misused. I consider myself a classicist or a member of the Chicago/Detroit school of mocking. That means I don’t mock often, and when I do I prefer to use hand rolled mocks because I find they’re better at letting me test state as opposed to interactions. Still, sometimes mocking frameworks can be damn handy and I’m not above using them. More often they’re part of an existing application that I’m working on. The main problem I see with them is when developers don’t stay SRY with their mocking. Every time you mock a method that’s a little dab of glue making it harder to change that method. I get sad when I come into a test and see a chunk of mocking repeated over and over in every test.

```java
User user = mock(User.class);
when(session.getUser()).thenReturn(user);
when(result.getName()).thenReturn(“Stacy”);
```

You will often find that these same lines are repeated throughout the system in many different tests, sometimes many times the number of invocations in the production code. If you want to change ```getUser()``` or ```getName()``` you may find that difficult, not due to the prod code but due to the mocker. I've litterally spent days refactoring tests and mocking statements so I could change some method automatically.

We can get around this the same way we stay DRY in our production code, through encapsulation and creating common utilities. In the above example, if this happens in one test we can easily extract a method for it. If it’s in many tests we can do the same but put it outside. I sometimes end up with a set of utilities for common methods. Something like this:

```java
public class SessionExpects {
     public static User currentUser(UserRepo userRepo, String name){
        User user = mock(User.class);
        when(session.getUser()).thenReturn(user);
        when(result.getName()).thenReturn(name);
	    return user;
     }
}
```

Now we can have only one place where these methods are called and if we need to change them it should be a lot easier. We also maintain the existing tests and other usages of the mocking framework. So it’s really low risk, low change, all we are doing is not repeating ourselves, which seems simple, and yet, maybe not obvious.
