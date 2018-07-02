SOURCES_BASE = core.kt
SOURCES_LISP = step0_repl.kt

SOURCES = $(SOURCES_BASE) $(SOURCES_LISP)
JARS = $(SOURCES_LISP:%.kt=%.jar)
SRC = src/main/kotlin/aboldt/kmal

all: $(JARS)

dist: mal.jar mal

mal.jar: stepA_mal.jar
	cp $< $@

SHELL := bash
mal: mal.jar
	cat <(echo -e '#!/bin/sh\nexec java -jar "$$0" "$$@"') mal.jar > $@
	chmod +x mal

clean:
	rm -vf $(JARS) mal.jar mal

$(JARS): %.jar: $(SRC)/%.kt $(SOURCES_BASE:%.kt=$(SRC)/%.kt)
	kotlinc $(SRC)/$(@:%.jar=%.kt) $(SOURCES_BASE:%.kt=$(SRC)/%.kt) -include-runtime -d $@

.PHONY: stats

stats: $(SOURCES:%.kt=$(SRC)/%.kt)
	@wc $^
	@printf "%5s %5s %5s %s\n" `grep -E "^[[:space:]]*//|^[[:space:]]*$$" $^ | wc` "[comments/blanks]"

stats-lisp: $(SOURCES_LISP:%.kt=$(SRC)/%.kt)
	@wc $^
	@printf "%5s %5s %5s %s\n" `grep -E "^[[:space:]]*//|^[[:space:]]*$$" $^ | wc` "[comments/blanks]"
