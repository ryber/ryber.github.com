---
layout: post
title: "ATDD vs xUnit Frameworks"
date: 2013-08-27 08:27
comments: true
categories: 
---

I’ve been in many debates about if acceptance testing should be done in a unit test framework or a “proper” ATDD tool like Cucumber or Fitnesse. Developers will change a unit test to do what they want in a heartbeat. They are more reluctant to change an acceptance test where the criteria is separated from the code. This is a very important distinction. I think a lot of developers think of unit tests as belonging to “them” and acceptance tests as belonging to “the business”.  

So yes, those test frameworks do suck, but they give you something that unit test frameworks just aren’t designed for. Whenever I see “acceptance tests” written in a unit test framework they just look like really poorly written unit tests, So take the extra time and use the right tool for the right job.

I have seen one exception to this. At Agile 2012 I attended a talk from <a href="https://twitter.com/lunivore">Liz Keogh</a> about <a href="http://agile2012.sched.org/event/e459c95d5ffa604772181091d142cb22">writing BDD tests in a domain specific syntax from within a unit test framework</a>. I thought it was a excellent idea and I have used the style on my own personal projects. I want to emphasize that what Liz has done is not entirely dissimilar to traditional ATDD frameworks. Her data, and criteria are absolutely separate from the underlying code. Even going so far as to abstract away top level controllers and domain objects behind fixtures. 

Here is an example of the "Keogh Style" testing from the unit test class. Note that those are all static methods of an external fixture class. In many ways it is no different than the text file side of Cucumber. All of the work of dealing with the underlying classes is behind the fixture leaving the jUnit methods with nothing but simple asserts.

    @Test
    public void canCountRegistrations() {
        givenCourse("abc", "Underwater Basketweaving");

        registerUserForCourse("abc", "barry");
        registerUserForCourse("abc", "gary");

        assertEquals(2, getRegistrationCount("abc"));

        registerUserForCourse("abc", "larry");
        registerUserForCourse("abc", "larry");

        assertEquals(3, getRegistrationCount("abc"));
    }
    
You can find more examples in <a href="https://github.com/ryber/Halleck/blob/master/src/test/java/BDDTests/RegistrationTests.java">this project</a>.