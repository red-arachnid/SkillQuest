
INSERT INTO skills (id, slug, name, category, description, icon, difficulty, estimated_hours) VALUES 
(1, 'davinci-resolve-beginner', 'DaVinci Resolve for Beginners', 'Video Editing', 'Master the core fundamentals of video editing using DaVinci Resolve. Learn project setup, media organization, rough cut assembly, transitions, basic color grading, audio cleanup, and final export settings.', 'faFilm', 'BEGINNER', 14),

(2, 'chess-beginner', 'Chess for Beginners', 'Board Games', 'Learn the royal game from scratch. Understand the board, piece movements, special rules, basic checkmate patterns, and foundational opening principles to play your first full games with confidence.', 'faChess', 'BEGINNER', 10),

(3, 'cpp-beginner', 'C++ Programming for Beginners', 'Programming', 'A comprehensive introduction to C++. Learn syntax, control flow, functions, memory management basics (pointers), and object-oriented programming fundamentals to start building console applications.', 'faCode', 'BEGINNER', 25),

(4, 'karate-beginner', 'Karate Fundamentals', 'Martial Arts', 'Step onto the dojo floor. Master basic etiquette, stances, punches, kicks, and blocks (Kihon), alongside an introduction to your first Kata and foundational self-defense concepts.', 'faUserNinja', 'BEGINNER', 15),

(5, 'mathematics-beginner', 'Mathematics Fundamentals', 'Education', 'Rebuild your mathematical foundation. This course covers core arithmetic operations, fractions, decimals, percentages, and basic 2D geometry, giving you the confidence to handle daily math.', 'faCalculator', 'BEGINNER', 12),

(6, 'mathematics-intermediate', 'Intermediate Mathematics', 'Education', 'Step up to pre-algebra and beyond. Dive into algebraic equations, linear functions, inequalities, graphing, and fundamental statistics and probability concepts necessary for advanced math.', 'faSquareRootAlt', 'INTERMEDIATE', 20);




INSERT INTO skill_modules (id, skill_id, title, position) VALUES
-- DaVinci Resolve Modules
(1, 1, 'Interface, Media Setup & Ingestion', 1),
(2, 1, 'Timeline Assembly & Essential Editing Tools', 2),
(3, 1, 'Audio Essentials, Titles & Color Basics', 3),
(4, 1, 'Finishing & Rendering for Export', 4),

-- Chess Beginner Modules 
(5, 2, 'The Board, Pieces, and Basic Movements', 1),
(6, 2, 'Special Moves, Rules, and Terminology', 2),
(7, 2, 'Basic Checkmates and Opening Principles', 3),

-- C++ Beginner Modules 
(8, 3, 'Environment Setup and Basic Syntax', 1),
(9, 3, 'Control Flow, Loops, and Functions', 2),
(10, 3, 'Arrays, Pointers, and Basic OOP', 3),

-- Karate Beginner Modules
(11, 4, 'Dojo Etiquette, Stretching, and Stances', 1),
(12, 4, 'Basic Blocks and Strikes (Kihon)', 2),
(13, 4, 'Basic Kicks and First Kata (Taikyoku Shodan)', 3),

-- Mathematics Beginner Modules
(14, 5, 'Core Arithmetic and Number Properties', 1),
(15, 5, 'Fractions, Decimals, and Percentages', 2),
(16, 5, 'Basic Geometry, Area, and Perimeter', 3),

-- Mathematics Intermediate Modules
(17, 6, 'Pre-Algebra and Solving Equations', 1),
(18, 6, 'Linear Functions, Graphing, and Inequalities', 2),
(19, 6, 'Statistics, Data, and Probability Basics', 3);




INSERT INTO skill_tasks (id, module_id, title, description, position, est_minutes, format) VALUES
-- DaVinci Resolve Tasks 
(1, 1, 'Project Setup and Workspace Overview', 'Configure project settings (frame rate, timeline resolution), navigate the primary pages (Media, Cut, Edit, Color, Fairlight, Deliver), and customize keyboard shortcuts.', 1, 45, 'VIDEO'),
(2, 1, 'Importing and Organizing Media', 'Import source files, create Smart Bins, set up metadata tags, and generate optimized media or proxies for smooth playback.', 2, 45, 'PRACTICE'),
(3, 2, 'Rough Cutting on the Edit Page', 'Learn 3-point editing using In and Out points, append/insert clips onto the timeline, and navigate with basic playback hotkeys (J-K-L).', 1, 60, 'PRACTICE'),
(4, 2, 'Trimming, Splitting, and Transitions', 'Use the Blade, Ripple Edit, and Roll tools to fine-tune cuts, and apply standard video/audio transitions like Cross Dissolves and Constant Power.', 2, 60, 'VIDEO'),
(5, 3, 'Basic Audio Mixing in Fairlight', 'Normalize dialogue volume levels, apply audio crossfades to remove clicks, balance background music, and apply built-in noise reduction plugins.', 1, 60, 'VIDEO'),
(6, 3, 'Color Page Fundamentals & Primary Corrections', 'Understand the primary wheels (Lift, Gamma, Gain, Offset), read the Waveform monitor, balance white balance, and contrast a shot across serial nodes.', 2, 90, 'PRACTICE'),
(7, 4, 'Adding Titles and Motion Graphics', 'Use Title templates and Text+ generators in the Edit page to build lower thirds, subtitles, and simple intro screens.', 1, 45, 'VIDEO'),
(8, 4, 'Exporting on the Deliver Page', 'Configure render presets for YouTube and Vimeo, set container formats (MP4/QuickTime), choose codecs (H.264/H.265), and export your first complete video.', 2, 45, 'PRACTICE'),

-- Chess Beginner Tasks 
(9, 5, 'Setting Up the Board and Coordinates', 'Learn how to orient the board (light square on the right) and read algebraic notation (ranks and files).', 1, 20, 'READ'),
(10, 5, 'The Pawn and Knight', 'Understand how pawns move and capture, and learn the unique L-shaped jumping movement of the knight.', 2, 30, 'INTERACTIVE'),
(11, 5, 'The Bishop, Rook, and Queen', 'Master the diagonal, straight, and combined long-range movements of these major and minor pieces.', 3, 30, 'INTERACTIVE'),
(12, 5, 'The King, Check, and Checkmate', 'Learn how the King moves, what it means to be in Check, and the ultimate goal of Checkmate.', 4, 25, 'VIDEO'),
(13, 6, 'Castling Rules and Strategy', 'Learn the conditions required to Castle (Kingside and Queenside) to protect your King.', 1, 20, 'VIDEO'),
(14, 6, 'En Passant and Pawn Promotion', 'Understand the special En Passant pawn capture and how to promote a pawn upon reaching the 8th rank.', 2, 30, 'PRACTICE'),
(15, 6, 'Checkmate vs Stalemate', 'Differentiate between winning the game (Checkmate) and drawing the game by leaving no legal moves (Stalemate).', 3, 25, 'INTERACTIVE'),
(16, 6, 'Piece Valuation and Trades', 'Learn the point values of pieces (P=1, N/B=3, R=5, Q=9) to evaluate if a trade is good or bad.', 4, 20, 'READ'),
(17, 7, 'Controlling the Center', 'Understand why fighting for the central four squares is crucial in the opening phase of the game.', 1, 30, 'VIDEO'),
(18, 7, 'Developing Pieces Effectively', 'Learn why Knights should usually be developed before Bishops, and why bringing the Queen out early is dangerous.', 2, 30, 'READ'),
(19, 7, 'The Ladder Checkmate', 'Practice delivering checkmate using two Rooks or a Queen and Rook by "rolling" the enemy King to the edge of the board.', 3, 40, 'PRACTICE'),
(20, 7, 'King and Queen vs King Checkmate', 'Learn the technique to restrict the enemy king into a box and deliver checkmate with just a King and Queen.', 4, 45, 'INTERACTIVE'),

-- C++ Beginner Tasks 
(21, 8, 'Setting Up Your IDE and Compiler', 'Install Visual Studio, CLion, or GCC, and configure your first project environment.', 1, 45, 'VIDEO'),
(22, 8, 'Hello World and Basic Syntax', 'Write your first C++ program, understand the main() function, includes, and basic console output using std::cout.', 2, 30, 'PRACTICE'),
(23, 8, 'Variables and Data Types', 'Learn about int, float, double, char, and bool, and how to declare, initialize, and modify variables.', 3, 40, 'READ'),
(24, 8, 'Basic Operators and Input', 'Use arithmetic and assignment operators, and learn how to take user input using std::cin.', 4, 30, 'INTERACTIVE'),
(25, 9, 'If/Else Statements and Logic', 'Implement conditional logic using if, else if, else, and understand boolean, logical, and comparison operators.', 1, 45, 'PRACTICE'),
(26, 9, 'Switch Statements', 'Learn how to use switch-case statements for cleaner menu-driven logic instead of multiple if/else blocks.', 2, 30, 'READ'),
(27, 9, 'While and For Loops', 'Master iteration by writing while loops, do-while loops, and standard for loops to repeat code blocks.', 3, 60, 'PRACTICE'),
(28, 9, 'Creating and Calling Functions', 'Understand function signatures, return types, passing arguments by value, and separating logic into reusable blocks.', 4, 60, 'VIDEO'),
(29, 10, 'Introduction to Arrays', 'Declare, initialize, and iterate through 1D arrays to store multiple items of the same data type.', 1, 45, 'INTERACTIVE'),
(30, 10, 'Understanding Pointers and References', 'Learn the basics of memory addresses, pointer syntax (* and &), and passing by reference to functions.', 2, 75, 'VIDEO'),
(31, 10, 'Structs and Grouping Data', 'Create custom data structures using structs to group variables of different types together.', 3, 40, 'PRACTICE'),
(32, 10, 'Classes and Basic Object-Oriented Concepts', 'Learn the difference between structs and classes, public/private access modifiers, and writing simple constructors.', 4, 90, 'READ'),

-- Karate Beginner Tasks 
(33, 11, 'Dojo Etiquette and Terminology', 'Learn bowing (Rei), counting to 10 in Japanese, and the respectful conduct required in a traditional dojo.', 1, 20, 'READ'),
(34, 11, 'Warm-ups and Flexibility', 'Follow a foundational dynamic stretching routine to prepare joints and muscles for martial arts training.', 2, 30, 'VIDEO'),
(35, 11, 'Making a Proper Fist and Posture', 'Understand the correct way to fold your fingers and thumb to prevent injury, and how to maintain an upright spine.', 3, 15, 'INTERACTIVE'),
(36, 11, 'Basic Stances (Dachi)', 'Practice the ready stance (Yoi), front stance (Zenkutsu Dachi), and horse-riding stance (Kiba Dachi).', 4, 45, 'PRACTICE'),
(37, 12, 'Straight Punch (Choku Zuki)', 'Learn the mechanics of twisting the hips and driving a punch from the chamber (Hikite) to the target.', 1, 40, 'VIDEO'),
(38, 12, 'High Block (Age Uke)', 'Practice defending your head with a rising block, ensuring proper angle and arm rotation.', 2, 30, 'PRACTICE'),
(39, 12, 'Outside and Inside Blocks (Soto & Uchi Uke)', 'Learn mid-level defense techniques to protect your torso from incoming straight attacks.', 3, 40, 'PRACTICE'),
(40, 12, 'Downward Block (Gedan Barai)', 'Master the sweeping downward block used to defend against lower body strikes or front kicks.', 4, 30, 'VIDEO'),
(41, 13, 'Chambering and Knee Strikes', 'Understand how every kick starts with a high knee chamber, and practice basic knee strikes.', 1, 30, 'PRACTICE'),
(42, 13, 'Front Snap Kick (Mae Geri)', 'Learn to execute a front snap kick using the ball of the foot (Koshi) with proper snap and retraction.', 2, 45, 'VIDEO'),
(43, 13, 'Roundhouse Kick Basics (Mawashi Geri)', 'Practice hip rotation, pivoting the base foot, and striking with the instep or ball of the foot.', 3, 60, 'PRACTICE'),
(44, 13, 'Introduction to Kata: Taikyoku Shodan', 'Combine your blocks, punches, and stances into the first predefined pattern of movements.', 4, 90, 'INTERACTIVE'),

-- Mathematics Beginner Tasks 
(45, 14, 'Addition and Subtraction Mastery', 'Review multi-digit addition and subtraction, carrying, borrowing, and mental math strategies.', 1, 30, 'PRACTICE'),
(46, 14, 'Multiplication Tables and Long Multiplication', 'Memorize tables up to 12x12 and practice standard algorithms for multiplying large numbers.', 2, 45, 'INTERACTIVE'),
(47, 14, 'Long Division', 'Learn the step-by-step process of long division, handling remainders, and checking your work.', 3, 50, 'VIDEO'),
(48, 14, 'Order of Operations (PEMDAS/BODMAS)', 'Understand the correct sequence to solve complex arithmetic expressions involving brackets and exponents.', 4, 40, 'PRACTICE'),
(49, 15, 'Understanding Fractions', 'Learn about numerators, denominators, proper/improper fractions, and mixed numbers.', 1, 40, 'READ'),
(50, 15, 'Adding and Subtracting Fractions', 'Find common denominators to successfully add and subtract fractions of different sizes.', 2, 45, 'PRACTICE'),
(51, 15, 'Introduction to Decimals', 'Understand place value beyond the decimal point and how to perform basic operations with decimal numbers.', 3, 40, 'VIDEO'),
(52, 15, 'Percentages and Conversions', 'Learn what a percentage is, how to calculate percentages of a number, and how to convert between fractions, decimals, and percents.', 4, 60, 'INTERACTIVE'),
(53, 16, 'Points, Lines, and Angles', 'Identify line segments, rays, and measure acute, right, obtuse, and straight angles.', 1, 30, 'READ'),
(54, 16, 'Properties of 2D Shapes', 'Classify triangles (isosceles, scalene, equilateral) and quadrilaterals (squares, rectangles, parallelograms).', 2, 35, 'INTERACTIVE'),
(55, 16, 'Perimeter Calculations', 'Learn how to calculate the total distance around various 2D polygons.', 3, 30, 'PRACTICE'),
(56, 16, 'Area of Squares, Rectangles, and Triangles', 'Use basic formulas (base x height, 1/2 base x height) to find the area of simple 2D shapes.', 4, 45, 'VIDEO'),

-- Mathematics Intermediate Tasks 
(57, 17, 'Introduction to Variables and Expressions', 'Learn how to use letters to represent unknown numbers and simplify basic algebraic expressions.', 1, 40, 'READ'),
(58, 17, 'Solving One-Step Equations', 'Use inverse operations (addition, subtraction, multiplication, division) to isolate the variable.', 2, 45, 'PRACTICE'),
(59, 17, 'Solving Two-Step and Multi-Step Equations', 'Combine like terms and use multiple inverse operations to solve complex linear equations.', 3, 60, 'INTERACTIVE'),
(60, 17, 'Introduction to Inequalities', 'Learn the symbols (>, <, >=, <=), how to solve basic inequalities, and graph them on a number line.', 4, 45, 'VIDEO'),
(61, 18, 'The Cartesian Coordinate System', 'Understand the X and Y axes, quadrants, and practice plotting points on a coordinate plane.', 1, 30, 'INTERACTIVE'),
(62, 18, 'Understanding Slope (Rise over Run)', 'Learn how to calculate the slope of a line from a graph or from two given coordinate points.', 2, 50, 'VIDEO'),
(63, 18, 'Slope-Intercept Form (y = mx + b)', 'Identify the slope and y-intercept from an equation and use them to quickly sketch a linear graph.', 3, 60, 'PRACTICE'),
(64, 18, 'Systems of Linear Equations (Graphing)', 'Solve systems of equations visually by graphing two lines and finding their exact point of intersection.', 4, 60, 'PRACTICE'),
(65, 19, 'Mean, Median, Mode, and Range', 'Calculate these fundamental measures of central tendency and dispersion from a set of data.', 1, 40, 'READ'),
(66, 19, 'Reading and Creating Histograms', 'Organize numerical data into bins and represent frequency distributions using histograms.', 2, 45, 'VIDEO'),
(67, 19, 'Introduction to Probability', 'Understand outcomes, events, and how to calculate the theoretical probability of simple single events (like rolling dice).', 3, 50, 'INTERACTIVE'),
(68, 19, 'Compound Probability (Independent Events)', 'Learn how to calculate the probability of two independent events happening together using the multiplication rule.', 4, 60, 'PRACTICE');




INSERT INTO resources (id, skill_id, task_id, title, type, url, is_free) VALUES
-- DaVinci Resources 
(1, 1, 1, 'Blackmagic Design Official DaVinci Resolve Beginner Guide', 'COURSE', 'https://www.blackmagicdesign.com/products/davinciresolve/training', b'1'),
(2, 1, 2, 'DaVinci Resolve Media Page & Smart Bins Tutorial', 'VIDEO', 'https://www.youtube.com/watch?v=63UNAm4GFHQ', b'1'),
(3, 1, 3, 'Complete Beginners Guide to Cutting in DaVinci Resolve', 'VIDEO', 'https://www.youtube.com/watch?v=1xEQGZvdc_Y', b'1'),
(4, 1, 4, 'Trimming and Editing Tools Deep Dive - Casey Faris', 'VIDEO', 'https://www.youtube.com/watch?v=9_zR2y219t0', b'1'),
(5, 1, 5, 'Audio Mixing and Fairlight for Beginners', 'VIDEO', 'https://www.youtube.com/watch?v=q64G5jL4m-k', b'1'),
(6, 1, 6, 'Beginners Guide to Color Grading in DaVinci Resolve - Waqas Qazi', 'COURSE', 'https://www.youtube.com/watch?v=t5JvD9pP2Y8', b'1'),
(7, 1, 7, 'How to Create Titles and Text in DaVinci Resolve', 'ARTICLE', 'https://filmora.wondershare.com/davinci-resolve/davinci-resolve-add-text-titles.html', b'1'),
(8, 1, 8, 'Best Export Settings for YouTube in DaVinci Resolve', 'VIDEO', 'https://www.youtube.com/watch?v=Xh3hKxR5r3w', b'1'),

-- Chess Resources 
(9, 2, 9, 'Setting up the Chess Board - Chess.com', 'ARTICLE', 'https://www.chess.com/article/view/how-to-set-up-a-chessboard', b'1'),
(10, 2, 10, 'Knight and Pawn Vision Training', 'INTERACTIVE', 'https://lichess.org/learn#/1', b'1'),
(11, 2, 11, 'Major Pieces Movement Drill', 'INTERACTIVE', 'https://lichess.org/learn#/3', b'1'),
(12, 2, 12, 'Understanding Check and the King', 'VIDEO', 'https://www.youtube.com/watch?v=F_O31T_KuvA', b'1'),
(13, 2, 13, 'How to Castle in Chess', 'VIDEO', 'https://www.youtube.com/watch?v=mC11J2m0kYI', b'1'),
(14, 2, 14, 'En Passant Rule Explained', 'ARTICLE', 'https://www.chess.com/terms/en-passant', b'1'),
(15, 2, 15, 'Checkmate vs Stalemate Exercises', 'INTERACTIVE', 'https://lichess.org/practice/basic-tactics/stalemate/1', b'1'),
(16, 2, 16, 'Piece Values in Chess', 'ARTICLE', 'https://www.chess.com/terms/chess-piece-value', b'1'),
(17, 2, 17, 'Controlling the Center - Opening Principles', 'VIDEO', 'https://www.youtube.com/watch?v=1KzEEDfE20c', b'1'),
(18, 2, 18, 'Piece Development Guide', 'ARTICLE', 'https://lichess.org/study/opening-principles', b'1'),
(19, 2, 19, 'Ladder Checkmate Practice Tool', 'INTERACTIVE', 'https://lichess.org/practice/checkmates/piece-checkmates-i/1', b'1'),
(20, 2, 20, 'King and Queen vs King Drill', 'INTERACTIVE', 'https://lichess.org/practice/checkmates/piece-checkmates-i/2', b'1'),

-- C++ Resources 
(21, 3, 21, 'Setting up C++ in Visual Studio', 'VIDEO', 'https://www.youtube.com/watch?v=18c3MTX0PK0', b'1'),
(22, 3, 22, 'C++ Hello World and Basics', 'ARTICLE', 'https://www.w3schools.com/cpp/cpp_getstarted.asp', b'1'),
(23, 3, 23, 'C++ Data Types Explained', 'ARTICLE', 'https://www.geeksforgeeks.org/c-data-types/', b'1'),
(24, 3, 24, 'Basic Input and Output in C++', 'INTERACTIVE', 'https://www.learncpp.com/cpp-tutorial/introduction-to-iostream-cout-cin-and-endl/', b'1'),
(25, 3, 25, 'C++ If/Else Conditions', 'ARTICLE', 'https://www.w3schools.com/cpp/cpp_conditions.asp', b'1'),
(26, 3, 26, 'Switch Statements Tutorial', 'ARTICLE', 'https://www.cplusplus.com/doc/tutorial/control/', b'1'),
(27, 3, 27, 'For and While Loops in C++', 'VIDEO', 'https://www.youtube.com/watch?v=b4N3KNEO8m8', b'1'),
(28, 3, 28, 'Functions in C++ Full Guide', 'COURSE', 'https://www.learncpp.com/cpp-tutorial/introduction-to-functions/', b'1'),
(29, 3, 29, 'Working with Arrays', 'INTERACTIVE', 'https://www.w3schools.com/cpp/cpp_arrays.asp', b'1'),
(30, 3, 30, 'C++ Pointers Explained Visually', 'VIDEO', 'https://www.youtube.com/watch?v=rtWAZq20z2Y', b'1'),
(31, 3, 31, 'C++ Structs Guide', 'ARTICLE', 'https://www.learncpp.com/cpp-tutorial/structs/', b'1'),
(32, 3, 32, 'Intro to Object Oriented Programming in C++', 'COURSE', 'https://www.youtube.com/watch?v=wN0x9eZLix4', b'1'),

-- Karate Resources 
(33, 4, 33, 'Dojo Etiquette and Rules', 'ARTICLE', 'https://blackbeltwiki.com/dojo-etiquette', b'1'),
(34, 4, 34, 'Karate Warm up Routine', 'VIDEO', 'https://www.youtube.com/watch?v=O1HkQoF5m3Y', b'1'),
(35, 4, 35, 'How to Make a Proper Karate Fist', 'ARTICLE', 'https://www.karatebyjesse.com/how-to-make-a-proper-fist/', b'1'),
(36, 4, 36, 'Basic Karate Stances Tutorial', 'VIDEO', 'https://www.youtube.com/watch?v=vVj_nB7R-xY', b'1'),
(37, 4, 37, 'Choku Zuki (Straight Punch) Mechanics', 'VIDEO', 'https://www.youtube.com/watch?v=1F9pS00dFks', b'1'),
(38, 4, 38, 'Age Uke (Rising Block) Details', 'ARTICLE', 'https://blackbeltwiki.com/age-uke', b'1'),
(39, 4, 39, 'Inside and Outside Blocks Drill', 'VIDEO', 'https://www.youtube.com/watch?v=UqQ-GZ1k2gU', b'1'),
(40, 4, 40, 'Gedan Barai (Downward Block) Guide', 'ARTICLE', 'https://blackbeltwiki.com/gedan-barai', b'1'),
(41, 4, 41, 'How to Chamber Kicks Properly', 'VIDEO', 'https://www.youtube.com/watch?v=x7E2n93A7Fk', b'1'),
(42, 4, 42, 'Mae Geri (Front Kick) Masterclass', 'VIDEO', 'https://www.youtube.com/watch?v=Q3T2A1D79E0', b'1'),
(43, 4, 43, 'Mawashi Geri (Roundhouse) Breakdown', 'VIDEO', 'https://www.youtube.com/watch?v=8VwQ9VqF8W8', b'1'),
(44, 4, 44, 'Taikyoku Shodan Kata Walkthrough', 'COURSE', 'https://www.youtube.com/watch?v=OQx_sP-9oW0', b'1'),

-- Math Beginner Resources
(45, 5, 45, 'Addition and Subtraction Strategies', 'ARTICLE', 'https://www.khanacademy.org/math/arithmetic/arith-review-add-subtract', b'1'),
(46, 5, 46, 'Multiplication Tables Drill', 'INTERACTIVE', 'https://www.mathsisfun.com/numbers/math-trainer-multiply.html', b'1'),
(47, 5, 47, 'Long Division Step-by-Step', 'VIDEO', 'https://www.youtube.com/watch?v=0uZiqk_ZdcA', b'1'),
(48, 5, 48, 'Order of Operations (PEMDAS)', 'ARTICLE', 'https://www.mathsisfun.com/operation-order-pemdas.html', b'1'),
(49, 5, 49, 'Introduction to Fractions', 'COURSE', 'https://www.khanacademy.org/math/arithmetic/fraction-basics', b'1'),
(50, 5, 50, 'Adding Fractions with Different Denominators', 'VIDEO', 'https://www.youtube.com/watch?v=tDQipGjPqyw', b'1'),
(51, 5, 51, 'Decimals Place Value Guide', 'ARTICLE', 'https://www.mathsisfun.com/decimals.html', b'1'),
(52, 5, 52, 'Fractions, Decimals, and Percents Converter', 'INTERACTIVE', 'https://www.mathplayground.com/Decention/index.html', b'1'),
(53, 5, 53, 'Basic Geometry: Angles and Lines', 'ARTICLE', 'https://www.mathsisfun.com/geometry/index.html', b'1'),
(54, 5, 54, 'Classifying Quadrilaterals', 'INTERACTIVE', 'https://www.khanacademy.org/math/basic-geo/basic-geometry-shapes/basic-geo-quadrilaterals', b'1'),
(55, 5, 55, 'Perimeter Basics', 'VIDEO', 'https://www.youtube.com/watch?v=AAY1bsazcgM', b'1'),
(56, 5, 56, 'Calculating Area of Polygons', 'COURSE', 'https://www.mathsisfun.com/area.html', b'1'),

-- Math Intermediate Resources
(57, 6, 57, 'Algebraic Expressions Introduction', 'ARTICLE', 'https://www.mathsisfun.com/algebra/index.html', b'1'),
(58, 6, 58, 'Solving One-Step Equations Game', 'INTERACTIVE', 'https://www.mathplayground.com/algebra_equations.html', b'1'),
(59, 6, 59, 'Solving Multi-Step Equations', 'VIDEO', 'https://www.youtube.com/watch?v=1c5HY3z4k8M', b'1'),
(60, 6, 60, 'Graphing Basic Inequalities', 'ARTICLE', 'https://www.mathsisfun.com/algebra/inequality.html', b'1'),
(61, 6, 61, 'The Coordinate Plane Plotting', 'INTERACTIVE', 'https://www.desmos.com/calculator', b'1'),
(62, 6, 62, 'Slope (Rise over Run) Explained', 'VIDEO', 'https://www.youtube.com/watch?v=ADlojiXkEps', b'1'),
(63, 6, 63, 'Graphing y = mx + b', 'ARTICLE', 'https://www.khanacademy.org/math/algebra/x2f8bb11595b61c86:forms-of-linear-equations/x2f8bb11595b61c86:intro-to-slope-intercept-form', b'1'),
(64, 6, 64, 'Solving Systems by Graphing', 'COURSE', 'https://www.mathsisfun.com/algebra/systems-linear-equations.html', b'1'),
(65, 6, 65, 'Mean, Median, Mode, and Range', 'ARTICLE', 'https://www.mathsisfun.com/data/central-measures.html', b'1'),
(66, 6, 66, 'How to Read a Histogram', 'VIDEO', 'https://www.youtube.com/watch?v=gDAYKJDEILQ', b'1'),
(67, 6, 67, 'Intro to Probability Theory', 'INTERACTIVE', 'https://www.mathsisfun.com/data/probability.html', b'1'),
(68, 6, 68, 'Independent Events & Compound Probability', 'ARTICLE', 'https://www.khanacademy.org/math/statistics-probability/probability-library', b'1');