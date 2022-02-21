# UIMA_Homework3

Jingyu Huang (jhuan146)
Kayla Laufer (klaufer1)

1. In the landing screen, when users switch between the two time modes, both the track and the
   thumb of the switch change colors. This is to emphasize contrast between two modes. A message
   is toasted to remind users of their choices each time they switch;
   In LearnEasy screen, we change the visibility of a button to indicate that it is selected and
   allow users to change their selections freely before clicking the "CHECK" to check the result;
   In LearnEasy screen, small button should be chosen when elapse<8, medium when 8<=elapse<=16, and
   large when elapse>16;
   For buttons at the bottom of the screen in Learn Mode, we use another color (blue) to 
   differentiate from that of the selection buttons (purple);
   On HardResult screen we implement two buttons that allow users to retry or go back to the
   landing screen.
   The layout looks the best on devices with larger resolutions and longer ratios. However, it does
   not look as nice when applied to wider tablets or devices like 3.7 FWVGA slider. This is because 
   we assign some margins directly to position certain elements instead of using flexible ones such 
   as ConstraintLayout. 
   Different APIs do not affect the functioning of this app as we have tested from API22 to API30.

2. It does not make sense to have six (or more?) different activities for this simple version of 
   the app since some activities are similar and therefore can be combined. To use less activities,
   we changed the visibility for certain features in the same activity. For example, the LearnHard
   and HardResult screens are the same activity, but some of the element's visibility changes when
   the buttons are clicked. Therefore, having more than six different activities is unnecessary, since
   similar screens can use the same activity by utilizing the visibility feature.

3. We tested our results for LearnEasy by running the activity multiple times. We calculated the time
   difference range and selected the appropriate button. We did this until we were able to test each
   result output multiple times.