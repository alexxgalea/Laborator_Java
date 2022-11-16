# Laborator_Java
Rezolvare tema java: server-multiclient

IHuman este interfata. Peste ea se ridica clasa Human(nu e abstracta-au fost implementate toate metodele din interfata)
Se deriveaza mai departe Student si Profesor in fisierele java aferente
Au fost suprascrise metoda de comparare si toString
Se poate observa modalitatea prin care se instantiaza obiectele de cele 2 tipuri -> am folosit constructorul in asa fel incat sa imi faciliteze comunicatia
->Faptul ca se trimite un string de la client la server, si acesta il parseaza (in cadrul unui nou fir de executie) si ridica o noua instanta pe care o adauga in una din cele 2 liste
Sistemul server-multiclient este preluat (https://www.geeksforgeeks.org/multithreaded-servers-in-java/)
Fac niste verificari in rutina threadului. La exit se vor sorta listele colectate si se vor trimite la clientul respectiv

Daca se doreste testarea functionalitatilor:
Se porneste serverul
Se porneste un client
Se vor trimite de catre client string uri ca cele prezentate in cadrul cerintei temei:
  *Student Nume Prenume Acronym Varsta An_Studiu
  *Profesor Nume Prenume Acronym Varsta Materie_Predata
In rutina threadului se uita in functie de Student si Profesor
La final se va trimite exit si in client se va primi raspunsul(nu prea frumos parsat dar nu am mai stat)

