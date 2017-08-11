Kéktúra (Java)
Írjon programot, amely nyilvántartást készít a kéktúrázókról, a hazánk leghosszabb összefüggő, körmentes 
turistaútvonalát (27 szakaszban összesen 1160 km) bejáró kirándulókról! Az egyes kirándulók adatai az első parancssori argumentumban 
megadott nevű szöveges állományban vannak leírva a következő formában:
turista_neve;szakasz_egyik_vége–szakasz_másik_vége[;szakasz_egyik_vége–szakasz_másik_vége]…
A sorban található sztringek mindegyike tetszőleges karaktereket tartalmazhat a pontosvessző és a kötőjel karakterek kivételével,
e két karakter kizárólag a többi sztring elválasztására szolgál. A szakaszokat a két végük jellemzi, 
ezek sorrendje azonban tetszőlegesen felcserélhető, a Bódvaszilas–Putnok szakasz például megegyezik a Putnok–Bódvaszilas szakasszal.
A program szakaszonként gyűjtse össze az őket teljesítő túrázókat, és írja a standard kimenetre a példa kimenetben látható formában
annak a szakasznak az adatait, amelyet a legtöbb túrázó teljesített! A szakasz két végpontját lexikografkus sorrendben adja meg: 
az egyik vége a lexikografikus sorrendben előrébb lévő vég legyen, a másik a hátrébb lévő!
A szakaszt teljesítők nevét szintén lexikografikusan növekvő sorrendben írja a kimenetre, a szakasz végpontjaitól egy kettőspont 
és egy szóköz, egymástól pedig egy-egy szóköz karakterrel elválasztva! Ügyeljen rá, hogy a sorok végén ne álljon felesleges szóköz!
Ha több olyan szakasz is lenne, amelyet egyformán sokan teljesítettek, akkor őket az elsőként megadott végpontjuk alapján állítsa sorba
és jelenítse meg a standard kimeneten!

Példa állomány (sample.txt):
Peter;Badacsonytordemic-Nagyvazsony;Putnok-Bodvaszilas
Gabor;Bodvaszilas-Putnok;Becske-Nograd
Nikolett;Nograd-Becske;Huvosvolgy-Piliscsaba;Sarvar-Sumeg
Aron;Sumeg-Sarvar;Dobogoko-Visegrad

Parancssori argumentumok:
sample.txt

A futtatás eredménye a standard kimeneten:
Becske-Nograd: Gabor Nikolett
Bodvaszilas-Putnok: Gabor Peter
Sarvar-Sumeg: Aron Nikolett
