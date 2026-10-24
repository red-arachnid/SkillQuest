INSERT INTO skills (id, slug, name, category, description, icon, difficulty, estimated_hours) VALUES
(2, 'basic-video-editing-premiere-pro', 'Basic Video Editing in Premiere Pro', 'Creative Skills', 'Learn a complete beginner workflow in Adobe Premiere Pro: organize footage, build a story, edit video and audio, add titles and color correction, then export polished videos.', 'faFilm', 'BEGINNER', 12);

INSERT INTO skill_modules (id, skill_id, title, position) VALUES
(7, 2, 'Getting Started and Project Setup', 1),
(8, 2, 'Importing and Organizing Media', 2),
(9, 2, 'Timeline Editing Fundamentals', 3),
(10, 2, 'Transitions, Effects, and Titles', 4),
(11, 2, 'Audio Editing and Mixing', 5),
(12, 2, 'Color Correction and Exporting', 6);

INSERT INTO skill_tasks (id, module_id, title, description, position, est_minutes, format, task_xp) VALUES
-- Module 7: Getting Started and Project Setup
(40, 7, 'Understand the Premiere Pro workspace', 'Identify the Project panel, Source Monitor, Timeline, and Program Monitor, and explain the purpose of each panel.', 1, 20, 'VIDEO', 10),
(41, 7, 'Create your first editing project', 'Create a new Premiere Pro project, choose a clear project name, and select a dedicated project folder.', 2, 5, 'PRACTICE', 15),
(42, 7, 'Set up an editing workspace', 'Open the Editing workspace, resize panels, and save a layout that makes the Project panel and Timeline easy to access.', 3, 2, 'VIDEO', 15),
(43, 7, 'Navigate monitors and timeline views', 'Practice playing, pausing, scrubbing, zooming, and moving the playhead in the Source and Program Monitors.', 4, 20, 'PRACTICE', 20),
(44, 7, 'Learn essential keyboard shortcuts', 'Use Premiere Pro keyboard shortcut settings to find and practice shortcuts for play, cut, undo, zoom, and selection tools.', 5, 25, 'PRACTICE', 20),
(45, 7, 'Make a workspace navigation drill', 'Open a project and complete a five-minute drill switching between Project, Source, Timeline, and Program panels without using menus.', 6, 15, 'PRACTICE', 20),

-- Module 8: Importing and Organizing Media (positions re-indexed 1-6)
(46, 8, 'Import video, audio, and image files', 'Import a small collection of video clips, music, voice-over, and images into the Project panel.', 1, 3, 'VIDEO', 15),
(47, 8, 'Organize assets with bins', 'Create bins for footage, audio, graphics, sequences, and exports, then place imported assets in the correct bins.', 2, 1, 'VIDEO', 20),
(49, 8, 'Preview footage in the Source Monitor', 'Open clips in the Source Monitor and review them before adding them to a sequence.', 3, 20, 'VIDEO', 15),
(50, 8, 'Mark useful In and Out points', 'Set In and Out points around the strongest part of at least five clips to prepare a select reel.', 4, 3, 'VIDEO', 25),
(51, 8, 'Create a subclip from the Project', 'Create a subclip from source clips or other subclips that are made up of a single media file.', 5, 5, 'READ', 20),
(52, 8, 'Build a select reel', 'Place your marked clips into a sequence in any order, creating a short collection of usable moments.', 6, 30, 'PRACTICE', 25),

-- Module 9: Timeline Editing Fundamentals (positions re-indexed 1-7)
(54, 9, 'Trim clips with clip edges', 'Trim the beginning and end of clips by dragging their edges so each shot starts and ends cleanly.', 1, 3, 'VIDEO', 25),
(55, 9, 'Cut clips with the Razor tool', 'Use the Razor tool to split clips at deliberate moments, then remove unnecessary sections.', 2, 5, 'VIDEO', 25),
(56, 9, 'Use ripple and rolling edits', 'Practice ripple and rolling trims on a short sequence while maintaining the timing of the overall edit.', 3, 7, 'VIDEO', 35),
(57, 9, 'Rearrange clips to improve story flow', 'Move clips into an order with a clear beginning, middle, and ending for a 30 to 60 second video.', 4, 10, 'PRACTICE', 35),
(58, 9, 'Use J, K, and L playback controls', 'Review an edit using reverse, pause, and forward playback controls, then make at least three pacing improvements.', 5, 5, 'PRACTICE', 20),
(59, 9, 'Create a rough cut', 'Assemble a complete rough cut between 45 and 90 seconds long using only the footage you organized.', 6, 5, 'PRACTICE', 45),
(60, 9, 'Review your rough cut critically', 'Watch the rough cut without editing and write down three moments that feel slow, confusing, or unnecessary.', 7, 20, 'PRACTICE', 25),

-- Module 10: Transitions, Effects, and Titles
(61, 10, 'Understand when transitions help', 'Learn why most edits should be simple cuts and identify moments where a dissolve can support the story.', 1, 20, 'READ', 15),
(62, 10, 'Apply a default video transition', 'Add a default video transition to suitable edits and adjust its duration so it does not feel distracting.', 2, 25, 'PRACTICE', 25),
(63, 10, 'Apply a simple audio transition', 'Add audio fades at the beginning or end of audio clips to avoid abrupt starts and stops.', 3, 20, 'PRACTICE', 20),
(64, 10, 'Add basic video effects', 'Apply one useful effect such as Crop, Gaussian Blur, or Transform and adjust it for a purposeful result.', 4, 30, 'PRACTICE', 25),
(65, 10, 'Create a main title', 'Use the Graphics workspace and Type tool to create a readable title for the beginning of your video.', 5, 20, 'READ', 25),
(66, 10, 'Add lower-third text', 'Create a lower-third graphic that introduces a person, place, or key idea without blocking important footage.', 6, 30, 'PRACTICE', 30),
(67, 10, 'Animate a graphic with keyframes', 'Use position or opacity keyframes to create a simple fade or movement for a title.', 7, 35, 'PRACTICE', 35),

-- Module 11: Audio Editing and Mixing
(68, 11, 'Separate dialogue, music, and effects', 'Place dialogue, music, and sound effects on separate audio tracks to make the mix easier to control.', 1, 20, 'PRACTICE', 20),
(69, 11, 'Set dialogue volume levels', 'Adjust dialogue clip gain and track levels so speech remains consistently understandable.', 2, 30, 'PRACTICE', 30),
(70, 11, 'Use Essential Sound audio types', 'Assign Dialogue, Music, Ambience, or SFX audio types in Essential Sound and explore the available controls.', 3, 5, 'VIDEO', 20),
(71, 11, 'Balance music under dialogue', 'Lower music beneath speech and use keyframes to make the volume change smoothly.', 4, 5, 'PRACTICE', 35),
(72, 11, 'Add clean audio fades', 'Add fade-ins and fade-outs to music and ambient sound so the sequence begins and ends naturally.', 5, 25, 'PRACTICE', 25),
(73, 11, 'Improve dialogue clarity', 'Use Essential Sound repair controls carefully to reduce distracting noise or improve speech clarity.', 6, 30, 'PRACTICE', 30),
(74, 11, 'Complete an audio review pass', 'Listen through the full timeline with headphones and correct three audio problems you notice.', 7, 30, 'PRACTICE', 35),

-- Module 12: Color Correction and Exporting
(75, 12, 'Understand basic color correction', 'Learn the difference between correcting exposure and white balance versus applying a creative color style.', 1, 6, 'READ', 15),
(76, 12, 'Correct exposure and contrast', 'Use Lumetri Color Basic Correction to improve exposure, contrast, highlights, shadows, whites, and blacks on a clip.', 2, 16, 'VIDEO', 25),
(77, 12, 'Fix white balance and saturation', 'Correct an obvious color cast with white balance controls, then make restrained saturation adjustments.', 3, 6, 'VIDEO', 30),
(78, 12, 'Match the look of two shots', 'Adjust two clips so their brightness and color feel visually consistent when played back-to-back.', 4, 35, 'PRACTICE', 40),
(79, 12, 'Perform a final quality check', 'Review the sequence for blank frames, spelling mistakes, abrupt audio, inconsistent color, and unwanted effects.', 5, 25, 'PRACTICE', 30),
(80, 12, 'Export an H.264 MP4 video', 'Export the final sequence as an H.264 MP4 using a Match Source high-bitrate preset and a clear output filename.', 6, 30, 'VIDEO', 30),
(81, 12, 'Complete the final editing project', 'Produce and export a polished 45 to 90 second video with organized media, clean cuts, titles, balanced audio, and basic color correction.', 7, 60, 'PRACTICE', 50);

INSERT INTO resources (id, skill_id, task_id, title, type, url, is_free) VALUES
(21, 2, 40, 'Get to know Premiere', 'VIDEO', 'https://www.adobe.com/learn/premiere-pro/web/get-started-premiere-pro', b'1'),
(23, 2, 42, 'Organize your workspace', 'VIDEO', 'https://youtu.be/CNMXZtuBiz4?t=23', b'1'),
(25, 2, 44, 'Find keyboard shortcuts', 'ARTICLE', 'https://helpx.adobe.com/in_hi/premiere/desktop/get-started/keyboard-shortcuts/default-keyboard-shortcuts.html', b'1'),

(27, 2, 46, 'Add clips to your sequence', 'VIDEO', 'https://www.adobe.com/learn/premiere-pro/web/add-clips-to-sequence', b'1'),
(28, 2, 47, 'How To Create & Use Bins In Premiere Pro', 'VIDEO', 'https://youtu.be/aCHYDmpDU-A', b'1'),
(31, 2, 50, 'How To Set & Clear In & Out Points', 'VIDEO', 'https://youtu.be/D_la459PSYs', b'1'),
(32, 2, 51, 'Create a subclip from the Project panel', 'ARTICLE', 'https://helpx.adobe.com/premiere/desktop/edit-projects/intro-to-editing/create-a-subclip-from-the-project-panel.html', b'1'),

(35, 2, 54, 'How to Trim and Cut Video', 'VIDEO', 'https://youtu.be/YJhJuuPAzvg', b'1'),
(36, 2, 55, 'How To Make Cuts', 'VIDEO', 'https://youtu.be/Q2u3nbDjg84', b'1'),
(37, 2, 56, 'Ripple Edit, Rolling Edit, Rate Stretch Tool in Premiere Pro', 'VIDEO', 'https://youtu.be/_3JqFk4PrTY', b'1'),

(42, 2, 61, 'Applying transitions in Premiere Pro', 'ARTICLE', 'https://helpx.adobe.com/premiere-pro/using/transition-overview-applying-transitions.html', b'1'),
(46, 2, 65, 'Create title graphics', 'ARTICLE', 'https://helpx.adobe.com/in_hi/premiere-pro/how-to/essential-graphics-panel.html', b'1'),
(48, 2, 67, 'How to Create TEXT ANIMATIONS', 'VIDEO', 'https://youtu.be/ysYADreX6U4', b'1'),

(51, 2, 70, 'Essential Sound audio types', 'VIDEO', 'https://youtu.be/13OCb1gMDUs', b'1'),
(52, 2, 71, 'BETTER VOICEOVERS WITH BACKGROUND MUSIC', 'VIDEO', 'https://youtu.be/oqaVL9mbyT0?t=18', b'1'),

(56, 2, 75, 'Color correction workflow', 'ARTICLE', 'https://helpx.adobe.com/premiere/desktop/correct-color/color-correction-fundamentals/color-correction-workflow.html', b'1'),
(57, 2, 76, 'How to Fix OVEREXPOSED Video in Premiere Pro!', 'VIDEO', 'https://youtu.be/TLke-3CJRiQ?t=15', b'1'),
(58, 2, 77, 'Fix White Balance and Saturation Tutorial', 'VIDEO', 'https://youtu.be/LIZGXvU69tU?t=10', b'1'),
(61, 2, 80, 'How to export and share video', 'ARTICLE', 'https://helpx.adobe.com/in_hi/premiere-pro/how-to/export-video-share-social-media.html', b'1');