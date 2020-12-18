AccountingAT_SKR-07.*
---------------------

Dies ist ein österreichischer Kontenplan, den ich im Mai 2014 auf Bitte der Firma Echotech 
und mit einem kleinen Sponsoringbeitrag derselben erstellt habe (die Community dankt!).
Ich hatte ein paar Tage vorher den neuen AccountingDE_SKR04minimal erstellt, so das diese 
beiden von der Herangehensweise her verwandt sind. Siehe hierzu auch:

  https://groups.google.com/forum/#!topic/idempiere-de/5tBcloQPX8g

Als Grundlage habe ich den SKR-07 der DATEV verwendet, der im grossen und ganzen den
österreichischen Standardkontenrahmen abbildet. Eine gute Definition desselben findet
sich unter http://www.datev.de/portal/ShowPage.do?pid=dpi&nid=84706



Um zu verstehen, was da ist und was nicht, sollte man wissen, wie ich vorgegangen bin:

Als Basis habe ich den AccountingDefaultsOnly genommen. Das ist ein Kontenplan, der nur
und ausschließlich die iDempiere Standardkonten enthält und dabei keine Kontonummern,
sondern symbolische Namen.

dunkelgelb
----------
Im ersten Schritt habe ich diesen Default-Konten - soweit ich das geschafft habe und 
eine Ahnung hatte, wofür iDempiere die Konten benutzt - die richtigen Kontonummern
zugeordnet.

hellgelb
--------
Im zweiten Schritt gibt es ein paar Konten, die man dringend haben sollte und die sich
aus den Defaultkonten ergeben. So gibt es z.B. ein Defaultkonto für Umsatzsteuer. In
der Praxis benötigt man aber ein solches Konto für jeden Steuersatz. Diese habe ich
weitgehend so erstellt, das man innerhalb des Landes Handel treiben und auch schonmal
eine EU-Rechnung erstellen kann. Wer mehr braucht (weltweit, EU-Dreiecksgeschäfte, etc.),
kann die entsprechenden Konten im Bereich der von mir erstellten aus dem DATEV-Dokument
heraussuchen und anlegen.

hellgrün
--------
Als nächstes habe ich alle Summenkonten, die der SKR-07 vorgibt, angelegt. Mit
Summenkonten ist das so eine Sache. Jeder will sie haben, aber eigentlich braucht man
sie nicht. Diese Einträge führen dazu, das die Konten in der Anzeige des Kontenplans
in einem hierarchischen Baum - ausgehend von den Kontenklassen - stehen. Das sieht erst
einmal gut aus, hilft aber eigentlich sonst nix. Eine weitere und viel praktischere
Eigenschaft der Summenkonten ist, das man sie in Finanzberichten zum Aufsummieren
benutzen kann. Meiner Erfahrung nach orientiert sich der Bedarf an Aufsummierungen
jedoch nicht unbedingt an der Hierarchie des Kontenplans. Es gibt übrigens prinzipiell
die Möglichkeit, die Konten (gleichzeitig!) in verschiedenen Bäumen zu organisieren und
je nach Bedarf die eine oder die andere Sortierung zu benutzen.

Ein besonderer Bedarfszweck sind die Bilanz und die GuV. Ob diese aus den vorhandenen
Summenkonten zusammengesetzt werden kann, habe ich nicht genau geprüft. Eine Verbesserung
des Kontenplans könnte sein, die Bilanz- und GuV-Spalten rechts in der Tabelle
entsprechend auszufüllen.

grau
----
Anschliessend habe ich aus dem vorhandenen Kontenplan der Firma Echotech (also einem
Real-Life-Kontenplan) die Konten herauszuextrahieren, die nun noch fehlen, damit man
glücklich wird. Das sind z.B. diverse Kostenkonten, Abschlusskonten, etc.



Aufteilung von ähnlichen Kosten auf mehrere Konten
--------------------------------------------------
Ein Unterschied, der in meiner eigenen Buchhaltung sehr auffällig war ist, das man in
iDempiere im allgemeinen keine Reihen von gleichen Konten anlegt, sondern
Buchführungsdimensionen nutzen kann. So buche ich die KfZ-Kosten immer auf ein und
dasselbe Konto und habe eine Buchführungsdimension, die es mir erlaubt, das entsprechende
FAhrzeug auszusuchen. Ich lege also nicht für jedes Fahrzeug ein Konto an. Ob man das
so oder so macht, bleibt einem bei einer geringen Anzahl von Fahrzeugen (Gebäuden, 
Mitarbeitern, Kostenstellen, etc.) natürlich selbst überlassen.



Import des Kontenplans
----------------------
Beim Import eines Kontenplans ist zu beachten, das das in zwei Schritten geschieht:

Bei der Anlage des Mandanten wird das COA-File angegeben. Damit werden nur die
Default-Konten (ca. 50) angelegt und im neuen Mandanten als Vorgabewerte der
Buchführung (für neue Datensätze) eingetragen.

Danach muss man den gesamten Knotenplan nochmals mittels des Importloaders in die
Importtabelle für Konten einlesen und dann importieren. Jetzt werden erst die restlichen
Konten angelegt.



Steuer
------
Ich erkläre noch einmal kurz, wie es hier in Deutschland läuft:

Im Kontenplan gibt es ein Default-Konto "3800 Umsatzsteuer". Dieses wird (da es als 
Default-Konto T_DUE_ACCT markiert ist) in alle Steuersätze als Umsatzsteuer-Konto als 
Vorgabe eingetragen. Da es in Deutschland aber die Vorschrift gibt, die verschiedenen 
USt-Sätze getrennt zu führen, muss man das ändern. Mein Kontenplan enthält also noch 
die Konten "3801 Umsatzsteuer 7%", "3806 Umsatzsteuer 19%" und "3802 Umsatzsteuer aus 
innergemeinschaftlichem Erwerb". Bei der Anlage der Steuersätze muss man diese dann 
manuell eintragen.

Eine Anleitung zum Thema Steuern gibt es übrigens auch hier (nicht von mir):

  http://wiki.idempiere.org/de/Musterfirma_einrichten_und_verwenden#Steuersatz_anlegen

Und ich habe gerade den Anlass genutzt, einen älteren Text von mir noch mal zu 
berarbeiten und auch einzustellen:

  http://wiki.idempiere.org/de/Steuers%C3%A4tze_einrichten



Thomas Bayen
BX Service GmbH, Krefeld
tbayen -at- bayen.de

