JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

# List all .java files to be compiled
CLASSES = QuickSort.java CustomIntList.java MergeSort.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	-del *.class
