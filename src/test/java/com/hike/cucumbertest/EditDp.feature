Story
As a user I want to be able to edit my DP
Acceptance Criteria
1. Once the user taps on the DP in ME tab, open a page with the full DP view of the user.
2. Provide options to upload a new DP via Camera or Gallery or to remove the existing DP
3. Once DP upload is complete bring the user back to this screen


NOte: For iOS there is no change in edit flow and hence it needs not be added in the scenarios.


Scenario: View Dp on tapping .
Given : User is on Me tab.
When: USer taps on the Circular overlay of the DP.
Then: The DP should open in full screen.

Scenario : Options for user to upload new DP.
Given: User is on me tab.
And: User Opens DP from ME-Tab.
When: Full view of the DP is seen.
THen: User should see "camera" and "gallery" option.

Scenario: Upload a new DP By clicking a picture.
Given: User is on me tab.
And: User Opens DP from ME-Tab.
When: User selects camera option.
Then : Camera should be launched and preview should be seen.


Given: User is on me tab.
And: User Opens DP from ME-Tab.
When: User selects camera option.
And  : Camera preview is seen.
Then : User should be able to click a picture from < Camera >.

Example:	| Camera	|
			| Primary	|
			| Secondary	|

Given: User is on me tab.
And: User Opens DP from ME-Tab.
When: User selects camera option.
And : Clicks a picture < Camera > 
Then: Option to "Retake " and " Use photo " should be seen.

Example:	| Camera	|
			| Primary	|
			| Secondary	|


Given : User is on me tab.
And: User Opens a DP from me-tab.
When : USer selects camera option.
And : Clicks a picture < Camera > 
And: Selects Use photo option.
Then: The captured picture should be seen with a circular overlay.
And: Option like "cancel" " update" and " edit" should be seen.

Example:	| Camera	|
			| Primary	|
			| Secondary	|

Given : User is on me tab.
And: User Opens a DP from me-tab.
When : USer selects camera option.
And : Clicks a picture < Camera > 
And: Selects Use photo option.
And: Selects  Update.
Then: The Dp of the user should get updated.
And : User should land on full screen view of DP.

Example:	| Camera	|
			| Primary	|
			| Secondary	|
			
			
Scenario: User selects picture from Gallery.
HS-747

			






