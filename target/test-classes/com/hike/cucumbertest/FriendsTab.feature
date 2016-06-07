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

Scenario: Launch hike when hike app is killed.
Given: User launches hike.
When: User selects friends tab
Then:User should be able to see camera icon on the top right corner of the screen.

Scenario: Launch hike when hike app is in background.
Given: User has hike installed.
And: User is one < Screen > 
And: User launches hike.
When : User taps on the friends tab.
Then: User should see the camera icon on the top right corner of the screen.

Example:
|	Screen		|
| Chat tab		|
| Me tab 		|

Scenario: Use quick photo option.
Given: User is on friends tab.
When: User taps on the "camera icon" .
Then: Grid view where first tile is camera preview and the rest of them are photos from gallery is seen.

Scenario: Use quick photo posts with device having no images .
Given: User is on friends tab.
When: User taps on the "camera icon" .
Then: Grid view where first tile is camera preview and the rest of the screen is empty.

Scenario: User has photos permission set on the device.
Given : User has hike installed.
And: On device settings > privacy > photos > off for hike.
When : User launches hike 
And: Navigates to > friends tab > camera icon.
Then : A pop up says "enable privacy for  photos from settings".

Scenario: User has  camera permission set on the device.
Given : User has hike installed.
And: On device settings > privacy > camera > off for hike.
When : User launches hike 
And: Navigates to > friends tab > camera icon > tap on camera ( first tile).
Then : A pop up says enable privacy from camera from settings.

Scenario: Capture Photo.
Given :User is on friends tab 
When:User taps on camera icon.
And: User selects camera from grid view.
Then : User should be taken to the camera preview screen.

Scenario: POst the capture photo without editing 
Given : User is on friends tab.
And: User taps on camera icon.
And: User chooses camera option.
When : User takes a picture .
And : Selects use photo.
And : Selects next 
And : Selects post.
Then : user is taken to the friends tab.

Scenario: Edit and post the photo.
Given : User is on friends tab.
And: User taps on camera icon.
And: User chooses camera option.
When : User takes a picture .
And : Selects use photo.
And : Selects a filter. 
And: Selects next.
And: Selects post.
Then : user is taken to the friends tab.

Scenario: Add a caption to the photo post.
Given : User is on friends tab.
And: User taps on camera icon.
And: User chooses camera option.
When : User takes a picture .
And : Selects use photo.
And : Selects a filter. 
And: Selects next.
And: Inserts a caption.
And: Selects post.
Then : User is taken to the friends tab.

Scenario: Post photo and observe on friends timeline. ( observation : recents gets updated and timeline has a caption " new updated availale".
Given : User A and User B are friends.
And: User B posts a photo.
When: User A is on Friends Tab.
Then: UserA's friends tab gets updated with recents 
And: A sub text " new updates available" is seen below timeline.

Scenario : Post a photo from gallery grid view.
Given : User is on friends tab.
And: User taps on camera icon.
When : User chooses a picture from the grid view.
And : Selects next 
And : Selects post.
Then : User is taken to the friends tab.

Scenario: Select a photo and select discard  update.
Given : User is on friends tab.
And: User selects Camera icon.
When: User selects a picture .
And: Selects next.
And: Selects the cancel from top left of the screen.
And: Selects "discard" option from the action sheet.
Then: User will land on friends tab.

Scenario: Select photo and select cancel.
Given : User is on friends tab.
And: User selects Camera icon.
When: User selects a picture .
And: Selects the cancel from top left of the screen.
Then : User should land on the grid view. 



Scenario: Open grid view and select Cancel( wil land on friends tab).
Scenario: Open timeline from notifications.( should land on friends tab and camera icon should be present)


