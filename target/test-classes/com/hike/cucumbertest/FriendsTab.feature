HS-928:
Acceptance Criteria
1. Remove friends option from the timeline overflow menu
2. Do not show friend requests inside timeline


Scenario: View time line .
Given: User A has hike 5.x installed.
When : User A goes to friends tab > timeline > tap on overflow menu
Then: User A should not see friends option among the 3 options.

Scenario: Receive friend request.
Given: User A gets a friend request from User B.
And: User A does not open the friend request notification.
And: User A opens hike.
When: User A navigates to friends tab > timeline > tap on overflow menu
Then: User A should not see the friend request  alert in timeline.

HS-811
Acceptance Criteria
1) Given the 3 tab re-design, when I open the friends tab, I should see a camera icon at the top of the action bar
2) Given I am in the friends tab, when I tap on the camera icon, I should be taken to the gallery view.
3) When I am posting the photo, I should be taken to the flow of posting it as a timeline update

Scenario: Navigate to timeline.
Scenario: User the camera share option.
Scenario: Capture Photo.
Scenario: POst the capture photo without editing 
Scenario: Edit and post the photo.
Scenario: Add a caption to the photo post.
Scenario: Post photo and observe on friends timeline. ( observation : recents gets updated and timeline has a caption " new updated availale".
Scenario : Post a photo from gallery grid view.
Scenario: select a photo and do not post.
Scenario: Select a photo and select discard  update ( will land on friends tab).
Scenario: Select photo and select cancel.( will land on grid view).
Scenario: Open grid view and select Cancel( wil land on friends tab).
Scenario: Open timeline from notifications.( should land on friends tab and camera icon should be present)


