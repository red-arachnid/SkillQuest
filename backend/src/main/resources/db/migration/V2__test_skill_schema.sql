

INSERT INTO skills (id, slug, name, category, description, icon, difficulty, estimated_hours) VALUES 
(1, 'davinci-resolve-beginner', 'DaVinci Resolve for Beginners', 'Video Editing', 'Master the core fundamentals of video editing using DaVinci Resolve. Learn project setup, media organization, rough cut assembly, transitions, basic color grading, audio cleanup, and final export settings.', 'faFilm', 'BEGINNER', 14);


INSERT INTO skill_modules (id, skill_id, title, position) VALUES
(1, 1, 'Interface, Media Setup & Ingestion', 1),
(2, 1, 'Timeline Assembly & Essential Editing Tools', 2),
(3, 1, 'Audio Essentials, Titles & Color Basics', 3),
(4, 1, 'Finishing & Rendering for Export', 4);


INSERT INTO skill_tasks (id, module_id, title, description, position, est_minutes, format) VALUES
(1, 1, 'Project Setup and Workspace Overview', 'Configure project settings (frame rate, timeline resolution), navigate the primary pages (Media, Cut, Edit, Color, Fairlight, Deliver), and customize keyboard shortcuts.', 1, 45, 'VIDEO'),
(2, 1, 'Importing and Organizing Media', 'Import source files, create Smart Bins, set up metadata tags, and generate optimized media or proxies for smooth playback.', 2, 45, 'PRACTICE'),
(3, 2, 'Rough Cutting on the Edit Page', 'Learn 3-point editing using In and Out points, append/insert clips onto the timeline, and navigate with basic playback hotkeys (J-K-L).', 1, 60, 'PRACTICE'),
(4, 2, 'Trimming, Splitting, and Transitions', 'Use the Blade, Ripple Edit, and Roll tools to fine-tune cuts, and apply standard video/audio transitions like Cross Dissolves and Constant Power.', 2, 60, 'VIDEO'),
(5, 3, 'Basic Audio Mixing in Fairlight', 'Normalize dialogue volume levels, apply audio crossfades to remove clicks, balance background music, and apply built-in noise reduction plugins.', 1, 60, 'VIDEO'),
(6, 3, 'Color Page Fundamentals & Primary Corrections', 'Understand the primary wheels (Lift, Gamma, Gain, Offset), read the Waveform monitor, balance white balance, and contrast a shot across serial nodes.', 2, 90, 'PRACTICE'),
(7, 4, 'Adding Titles and Motion Graphics', 'Use Title templates and Text+ generators in the Edit page to build lower thirds, subtitles, and simple intro screens.', 1, 45, 'VIDEO'),
(8, 4, 'Exporting on the Deliver Page', 'Configure render presets for YouTube and Vimeo, set container formats (MP4/QuickTime), choose codecs (H.264/H.265), and export your first complete video.', 2, 45, 'PRACTICE');


INSERT INTO resources (id, skill_id, task_id, title, type, url, is_free) VALUES
(1, 1, 1, 'Blackmagic Design Official DaVinci Resolve Beginner Guide', 'COURSE', 'https://www.blackmagicdesign.com/products/davinciresolve/training', b'1'),
(2, 1, 2, 'DaVinci Resolve Media Page & Smart Bins Tutorial', 'VIDEO', 'https://www.youtube.com/watch?v=63UNAm4GFHQ', b'1'),
(3, 1, 3, 'Complete Beginners Guide to Cutting in DaVinci Resolve', 'VIDEO', 'https://www.youtube.com/watch?v=1xEQGZvdc_Y', b'1'),
(4, 1, 4, 'Trimming and Editing Tools Deep Dive - Casey Faris', 'VIDEO', 'https://www.youtube.com/watch?v=9_zR2y219t0', b'1'),
(5, 1, 5, 'Audio Mixing and Fairlight for Beginners', 'VIDEO', 'https://www.youtube.com/watch?v=q64G5jL4m-k', b'1'),
(6, 1, 6, 'Beginners Guide to Color Grading in DaVinci Resolve - Waqas Qazi', 'COURSE', 'https://www.youtube.com/watch?v=t5JvD9pP2Y8', b'1'),
(7, 1, 7, 'How to Create Titles and Text in DaVinci Resolve', 'ARTICLE', 'https://filmora.wondershare.com/davinci-resolve/davinci-resolve-add-text-titles.html', b'1'),
(8, 1, 8, 'Best Export Settings for YouTube in DaVinci Resolve', 'VIDEO', 'https://www.youtube.com/watch?v=Xh3hKxR5r3w', b'1');
