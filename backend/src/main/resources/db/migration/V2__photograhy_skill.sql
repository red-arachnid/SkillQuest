INSERT INTO skills (id, slug, name, category, description, icon, difficulty, estimated_hours) VALUES 
(1, 'photography-beginner', 'Photography Beginner', 'CREATIVE', 'A beginner-friendly photography course covering camera controls, exposure, composition, natural light, focus, and basic editing. Learners finish with a small portfolio of intentional photographs.', 'faCamera', 'BEGINNER', 18);

INSERT INTO skill_modules (id, skill_id, title, position) VALUES
(1, 1, 'Getting Comfortable with Your Camera', 1),
(2, 1, 'Mastering Exposure', 2),
(3, 1, 'Composition Fundamentals', 3),
(4, 1, 'Working with Light and Color', 4),
(5, 1, 'Focus, Depth of Field and Lenses', 5),
(6, 1, 'Editing and Your First Portfolio', 6);

INSERT INTO skill_tasks (id, module_id, title, description, position, est_minutes, format, task_xp) VALUES
-- Module 1: Getting Comfortable with Your Camera
(1, 1, 'Watch the photography basics overview', 'Watch a short beginner overview of aperture, shutter speed, ISO, and how a camera creates an image.', 1, 15, 'VIDEO', 10),
(2, 1, 'Identify your camera controls', 'Find the power button, mode dial, shutter button, zoom or lens controls, screen, and menu button on your camera or phone camera app.', 2, 15, 'PRACTICE', 15),
(3, 1, 'Learn the main shooting modes', 'Learn what Auto, Program, Aperture Priority, Shutter Priority, and Manual modes are used for.', 3, 15, 'READ', 10),
(4, 1, 'Take your first ten photos', 'Photograph one simple object from ten different distances and angles using Auto mode.', 4, 25, 'PRACTICE', 25),
(5, 1, 'Understand image resolution and aspect ratio', 'Learn what megapixels, image size, and aspect ratio mean for sharing and printing photos.', 5, 10, 'READ', 10),
(7, 1, 'Review your first photos', 'Choose your best and weakest photo from the ten-photo exercise and write one sentence explaining each choice.', 7, 15, 'PRACTICE', 20),

-- Module 2: Mastering Exposure
(8, 2, 'Learn the exposure triangle', 'Understand how aperture, shutter speed, and ISO work together to control brightness.', 1, 20, 'READ', 15),
(9, 2, 'Watch exposure explained simply', 'Watch a beginner-friendly explanation of the exposure triangle and its creative effects.', 2, 5, 'VIDEO', 10),
(10, 2, 'Explore aperture', 'Learn how aperture affects both brightness and how much of the photo is in focus.', 3, 15, 'READ', 15),
(11, 2, 'Practice aperture with one subject', 'Photograph the same subject using a wide aperture and a narrow aperture, then compare background blur.', 4, 25, 'PRACTICE', 30),
(12, 2, 'Explore shutter speed', 'Learn how fast and slow shutter speeds freeze or blur movement.', 5, 15, 'READ', 15),
(13, 2, 'Practice motion blur and freezing', 'Take one photo that freezes moving water or a moving person, and one that intentionally shows motion blur.', 6, 25, 'PRACTICE', 35),
(14, 2, 'Use an exposure simulator', 'Use an interactive camera simulator to adjust aperture, shutter speed, and ISO and observe the results.', 7, 20, 'INTERACTIVE', 30),

-- Module 3: Composition Fundamentals
(15, 3, 'Learn the rule of thirds', 'Understand how to place subjects along imaginary gridlines to create balanced photos.', 1, 15, 'READ', 10),
(16, 3, 'Watch a rule-of-thirds lesson', 'Watch a practical demonstration of using the rule of thirds in photography.', 2, 15, 'VIDEO', 10),
(17, 3, 'Practice rule-of-thirds framing', 'Take five photos with the main subject placed off-center using the rule-of-thirds grid.', 3, 25, 'PRACTICE', 25),
(18, 3, 'Find leading lines', 'Learn how roads, fences, walls, and shadows can guide the viewer’s eye through an image.', 4, 15, 'READ', 10),
(19, 3, 'Photograph leading lines', 'Find and photograph three natural or man-made leading lines around your home or neighborhood.', 5, 25, 'PRACTICE', 30),
(20, 3, 'Use framing and negative space', 'Learn how to frame a subject using doorways, windows, or branches, and how empty space can strengthen a photo.', 6, 20, 'READ', 15),
(21, 3, 'Create a composition set', 'Photograph one subject using rule of thirds, leading lines, framing, and negative space.', 7, 30, 'PRACTICE', 40),

-- Module 4: Working with Light and Color
(22, 4, 'Learn the qualities of light', 'Understand hard versus soft light, light direction, and how light changes the mood of a photo.', 1, 20, 'READ', 15),
(23, 4, 'Watch a natural-light introduction', 'Watch a beginner lesson on golden hour, midday light, window light, and overcast conditions.', 2, 15, 'VIDEO', 10),
(24, 4, 'Photograph front, side, and backlight', 'Photograph the same subject with light coming from the front, side, and behind it.', 3, 30, 'PRACTICE', 35),
(25, 4, 'Use window light indoors', 'Photograph an object near a window using soft, directional light.', 4, 20, 'PRACTICE', 25),
(26, 4, 'Learn white balance and color temperature', 'Understand why photos can look too orange or too blue and how white balance corrects color.', 5, 15, 'READ', 15),
(27, 4, 'Practice white balance', 'Photograph the same indoor scene using daylight, cloudy, tungsten, and auto white balance settings.', 6, 20, 'PRACTICE', 30),

-- Module 5: Focus, Depth of Field and Lenses
(28, 5, 'Learn autofocus basics', 'Understand autofocus points, single autofocus, continuous autofocus, and when to use each.', 1, 15, 'READ', 15),
(29, 5, 'Practice selecting a focus point', 'Take five photos while deliberately choosing different focus points on your subject.', 2, 20, 'PRACTICE', 25),
(30, 5, 'Learn depth of field', 'Understand how aperture, distance, and focal length affect how much of a scene appears sharp.', 3, 20, 'READ', 20),
(31, 5, 'Create shallow and deep depth of field', 'Photograph one subject with a blurred background and another version where the entire scene is sharp.', 4, 25, 'PRACTICE', 35),
(32, 5, 'Learn focal length basics', 'Understand the difference between wide-angle, standard, and telephoto views.', 5, 15, 'READ', 15),
(33, 5, 'Compare wide and close perspectives', 'Photograph the same scene from a wide viewpoint and then move closer for a tighter view.', 6, 25, 'PRACTICE', 30),

-- Module 6: Editing and Your First Portfolio
(34, 6, 'Set up a simple editing workflow', 'Learn a basic editing order: crop, exposure, contrast, white balance, highlights, shadows, and export.', 1, 15, 'READ', 15),
(35, 6, 'Try a browser-based photo editor', 'Open Photopea and explore its basic editing tools using one of your own photos.', 2, 20, 'INTERACTIVE', 25),
(36, 6, 'Edit exposure and contrast', 'Adjust exposure, contrast, highlights, and shadows on one photo without making it look unnatural.', 3, 25, 'PRACTICE', 30),
(37, 6, 'Crop for stronger composition', 'Crop three older photos to improve balance, remove distractions, or apply the rule of thirds.', 4, 20, 'PRACTICE', 25),
(38, 6, 'Edit color and white balance', 'Correct the color cast in one photo and make a subtle creative color adjustment.', 5, 20, 'PRACTICE', 30),
(39, 6, 'Build a five-photo beginner portfolio', 'Select and lightly edit five of your best photos from this course, choosing images that show different skills.', 6, 45, 'PRACTICE', 50);

INSERT INTO resources (id, skill_id, task_id, title, type, url, is_free) VALUES
-- Module 1
(1, 1, 1, 'Photography Basics in 13 Minutes', 'VIDEO', 'https://www.youtube.com/watch?v=fpdxMUWF0k0', 1),
(2, 1, 3, 'Camera Modes Explained', 'ARTICLE', 'https://photographylife.com/understanding-digital-camera-modes', 1),
(3, 1, 5, 'Understanding Aspect Ratio', 'ARTICLE', 'https://www.adobe.com/express/discover/sizes/photo-aspect-ratio', 1),

-- Module 2
(4, 1, 8, 'Camera Exposure: Aperture, ISO and Shutter Speed', 'ARTICLE', 'https://www.cambridgeincolour.com/tutorials/camera-exposure.htm', 1),
(5, 1, 9, 'Master the Exposure Triangle', 'VIDEO', 'https://www.youtube.com/watch?v=gQ6Q7fi28uY', 1),
(6, 1, 10, 'What Is Aperture in Photography?', 'ARTICLE', 'https://photographylife.com/what-is-aperture-in-photography', 1),
(7, 1, 12, 'What Is Shutter Speed in Photography?', 'ARTICLE', 'https://photographylife.com/what-is-shutter-speed-in-photography', 1),
(8, 1, 14, 'Interactive Camera Simulator', 'INTERACTIVE', 'https://photographyicon.com/camera-simulator/', 1),

-- Module 3
(9, 1, 15, 'Rule of Thirds in Photography', 'ARTICLE', 'https://digital-photography-school.com/rule-of-thirds/', 1),
(10, 1, 16, 'Photography Composition: Rule of Thirds', 'VIDEO', 'https://youtu.be/I1OK3yeuO_s', 1),
(11, 1, 18, 'Using Leading Lines in Photography', 'ARTICLE', 'https://www.adobe.com/creativecloud/photography/technique/leading-lines.html', 1),
(12, 1, 20, 'Framing and Negative Space in Photography', 'ARTICLE', 'https://www.adobe.com/creativecloud/photography/type/negative-space-photography.html', 1),

-- Module 4
(13, 1, 22, 'Understanding Light in Photography', 'ARTICLE', 'https://photographylife.com/photography-lighting-setups', 1),
(14, 1, 23, 'Natural Light: Beginner’s Guide to Stunning Photos', 'VIDEO', 'https://www.youtube.com/watch?v=OC9p9K4KISU', 1),
(15, 1, 26, 'White Balance and Color Temperature Explained', 'ARTICLE', 'https://photographylife.com/understanding-white-balance', 1),

-- Module 5
(16, 1, 28, 'Autofocus Modes Explained', 'ARTICLE', 'https://photographylife.com/autofocus-modes', 1),
(17, 1, 30, 'What Is Depth of Field in Photography?', 'ARTICLE', 'https://photographylife.com/what-is-depth-of-field', 1),
(18, 1, 32, 'Focal Length Explained', 'ARTICLE', 'https://www.adobe.com/creativecloud/photography/discover/focal-length.html', 1),

-- Module 6
(19, 1, 34, 'Basic Photo Editing Workflow for Beginners', 'ARTICLE', 'https://www.adobe.com/learn/photoshop/paths/photo-editing', 1),
(20, 1, 35, 'Photopea Free Online Photo Editor', 'INTERACTIVE', 'https://www.photopea.com/', 1);