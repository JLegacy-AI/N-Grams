PROJECT:			N-Gram Application
Language:			Java
Tech-Used:			Threads, Basic Java
Design-Patterns:		Factory Design Pattern

This application is for making n-grams range from 1-n grams, application contain 5 options,
	-first option allow you to give the directory of files which contain all text files 
	-second option allow you to give the n number of grams 
	-third option allow you to give OUTPUT file name with path with csv extension
	-fourth option allow you to start the building of grams after all giving information

Directory Files are not hard coded, user can give any files directory which contains text files,
give the grams, give output file directory with csv, then start building grams. In every step 
progress bar run on other threads this thread wait for its completion and for completion of tasks.

