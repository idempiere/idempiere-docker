Banken.csv
----------
ist eine Liste aller deutschen Banken mit Bankleitzahl und Swift-Code/BIC. Sie kann per CSV-Import in
iDempiere (nur möglich auf der Weboberfläche) importiert werden. Diese Liste erspart, Banken anzulegen, wenn ein
Geschäftspartner dort ein Konto hat.

AccountingDE_SKR04minimal.fods
------------------------------
Ein von mir erstellter Kontenplan. Die Default-Konten, die iDempiere benutzt, sind soweit irgend möglich
ordentlich zugeordnet (wer weitere Hinweise zu den restlichen hat, bitte melden!). Außderdem ist eine
hierarchische Gliederung auf eine Bilanz und GuV nach HGB-Vorschriften enthalten.

In der Datei sind verschiedene ARten von Konten farblich unterschieden:

dunkelorange:	Bilanz Gliederungskonten nach HGB
hellorange:	Gewinn- und Verlust Gliederungskonten nach HGB
dunkelgelb:	Default-Konten von iDempiere
hellgelb:	für deutsche Buchhaltung dringend empfohlene Ergänzungen zu den Standardkonten
grau/weiss:	weitere Konten, um ein ordentliches Gerüst eines Mini-SKR04 zu erzeugen

AccountingDE_SKR**_vor2012.xls
------------------------------
Das sind die alten Dateien, die von ADempiere übernommen worden sind. Ich weiss nicht, wer sie erstellt hat. Ich
habe sie bei der Erstellung des "SKR04minimal" nicht benutzt. Außerdem haben sie eine andere Art, die Hierarchie 
abzubilden (nämlich innerhalb des Kontenbereichs der normalen, numerisch bezeichneten, Konten - anstatt in einem 
eigenen Bereich wie von mir gemacht). Sie stellen also ggf. eine alternative "Quelle des Wissens" mit einer
alternativen Herangehensweise dar. 

AccountingDefaultsOnly.fods
---------------------------
Eine absolut minimale "Chart of Accounts" Datei, die man benutzen kann, um das Programm zu installierene, wenn
man eigentlich gar keinen Kontenplan installieren möchte (weil man z.B. gar keine Buchhaltung nutzen möchte).
Die Konten haben keine Kontonummern, sondern die symbolischen Namen der Default-Konten.

Wer möchte, kann die Namen der Konten später in Kontonummern ändern und so doch noch zu einer normalen
Buchhaltung migrieren.

Eine Zwischenlösung dieser Idee ist die Datei AccountingDE_BilanzOhneKontonummern. Sie enthält nur die
Default-Konten ohne Nummern, fügt allerdings eine Glieder der Bilanz und GuV nach HGB hinzu. Diese Datei dient
eher der Ansicht für interessierte. Wer eine Bilanz haben möchte, wird in den allermeisten Fällen den SKR04
vorziehen.

