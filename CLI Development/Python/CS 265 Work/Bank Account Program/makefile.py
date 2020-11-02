.PHONY : build view clean

build :
	@# "Not much to do here.  I did this in Python"
	chmod +x accountmenu

view :
	@\less accountmenu

clean :
	@\rm *.pyc