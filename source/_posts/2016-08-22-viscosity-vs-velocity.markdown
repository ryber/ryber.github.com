---
layout: post
title: "Viscosity vs Velocity"
date: 2016-08-22 13:27
comments: true
categories: agile
---

Velocity is a largely meaningless “measurement”. It’s relative, it’s based on estimation (which we are all horrible at), and it’s subject to all kinds of external forces that impact teams.

A much better thing to measure are the forces hampering our teams from delivering. I like to think of this as viscosity. In science, viscosity is a measurement for how fluid a liquid is.  Water flows faster and easier than honey. Similarly, our teams will go as fast as they are capable of. The real issue is finding what is slowing them down.

I came up with an entirely unscientific method for calculating a team’s viscosity. In the course of a team delivering something to their customer:

1. **Start with 1 point**
1. **Add 1 Point** for each external team or person (not on the team) you are dependent on in order to deliver. This could be DBA’s architects, operations, security, marketing, etc etc. It could also be another team responsible for some other part of a feature. Maybe your teams are split between “back end” and “UI” for example.
1. **Add 1 Point** for each required technology needed that your team is not proficient in.

Easy huh? Your goal is a value of **1**. Obviously not all values of 1 are equal but it should give you a target to work on. You are free to play with the point system. Maybe dependencies outside of your company or area cost more?

 Teams that are self sufficient are going to be faster or at least be more responsible for their own speed. What would it take to get a team with all of the skills and people needed to deliver?

Of course teams impact other teams. Viscosity is all about how a liquid moves in relation to itself. What’s really fun is to take all of the viscosity points for an organization and cross them together. So rather than just run the points of each team, inherit the points from your dependencies. So if your team is dependent on a team with a viscosity of 5 then you now also have 5 as well (plus whatever else).

Map this out and you will start to see the big bottlenecks of your organization. You could create a nice dependency graph and watch as it explodes. Teams that should be really fast suddenly look slow because of a web of other slow teams (usually built to “support” them).

<img src="/assets/images/viscosity.png" align="right" />
