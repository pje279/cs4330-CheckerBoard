# Retrospective
pje279 - (4/12/18)

---

### 1. Reflect on (think about) the work you did for the challenge. How did you do? What did you get right? What did you get wrong? What did you do differently (and possibly better) than what was posted in the solution? What was hard to do?
  I believe I did well enough. I managed to meet all of the requirements we were given, and implemented the desired behavior. I did a few things differently, namely the handling of events when changing the number of rows and columns, the color scheme. The hardest part was honestly just remembering how to use NetBeans/Java (it's been a few years since I last used them), as well as getting used to using JavaFX as I had not used it prior to this assignment.

### 2.  How well did you understand the programming concepts and foundational knowledge needed to complete the challenge?
  I believe I understood it pretty much perfectly well. Nothing about the assignment was difficult or complicated for me.

### 3. How well did you meet the requirements as set out in the challenge? What requirements did you not meet correctly (if any)?
  To my knowledge, I met all of them, or at least that's what my grade appears to indicate.

### 4. How well does your solution match the posted solution? What is different?
  Overall, it's very similar, with a few differences. The ones noted about in question 1, about some of the event handling, keeping track of the color scheme (I just used a boolean to indicate which should be used, and then hard coded the colors in, rather than using a method to set the colors and getting them from a property (in retrospect (ha) that's probably a better way to do it than what I did)).
	
### 5. How could you improve going forward? What don't you still understand that was required for the challenge?
  As mentioned before in question 4, I probably should have used properties on the controller class to keep track of which color to draw the board with so as to make it easier to modify later if need be, rather than having it hard coded in multiple places. As well, after looking at the solution for the logic in building the board itself, I could have simplified and shortened my approach, which would have helped to avoid repeating code.
