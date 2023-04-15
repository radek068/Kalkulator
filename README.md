# Kalkulator
Autor Radosław Staniów
- tel 791 190 602
- email radek.staniow582@gmail.com

Kalkulator konsolowy, umożliwia użytkownikowi wykonywanie podstawowych operacji matematycznych za pomocą wiersza poleceń. Dzięki niemu użytkownik może dodawać, odejmować, mnożyć i dzielić liczby.

istnieje możliwość wykonania działania za pomocą argumentów.
- -a --add        dla dodawnia     (+) 
- -s --subtract   dla odejmowania  (-)
- -m --multiply   dla mnozenia     (*)
- -d --divide     dla dzielenia    (/)

Użytkownik może przekazać do programu co pomocą argumentów jakie działanie chce wykonać oraz dwie liczby, 
a na początku działania programu zostanie wykonane podana operacja.

Podczas działania programu użytkownik może kożystać z komend 
- help              do wyświetlenia pomocy wewnątrz programu.
- history           do wyświetlenia wszystkich pomyślnie wykonanych operacji w bieżącej sesji.
- history-detailed  do wyświetlenia szczegółowych informacji na temat jednej z operacji wylistowanej za pomocą komendy history
- exit              do wyjścia z programu.

Do wykonywania operacji użytkownik musi wprowadzić całe wyrażenie w jednym wierszu jako pojedyncze wejście, w formacie: <liczba> <operator> <liczba>

Przykład wyrażenia:
- 1 + 2.5
- 3.5 * 4
- 8 / 2

W programie jest też możliwość użycia w operacji wyniku poprzeniego działania poprzez pominięcie pierwszej liczby

Przykład wyrażenia:
- +5
- -7.5
- /6

aplikacja sprawdza popraność wpisanych przez użytkownika operacji, nie jest wrażliwa na używanie spacji tzn. 
wyrażenie "3 + 4" zadziała poprawnie i w identyczny sposób co wyrażenie "3+4".

Aplikacja przechowuje historie wszystkich poprawnie wykonanych operacji dla każdej operacji przechowywane są informacje (które można wyświetlić za pomocą komendy history-detailed):
- wartość pierwszej liczby.
- wartość drugiej liczby.
- jaka operacja została przeprowadzona.
- wynik operacji.
- dokładna godzina wykonania operacji.
- czy do wykonania operacji posłużył wynik operacji poprzedniej.
- numer poprzedniej operacji.

Do uruchomienia aplikacji wymagane jest JDK javy w wersji 17.x zainstalowane na komputerze.
Aby uruchomić aplikację należy pobrać plik Kalkulator.jar z repozytorium 
włączyć konsole odnaleźć plik wpisać 

java -jar Kalkulator.jar (argumenty)

Aplikacja powinna poprawnie się uruchomić a na ekranie powinna zostać wyświetlona powitalna wiadomość "Welcome to the calculator program..."
użyta w programie biblioteka JCommander została załączona do jara więc Java nie powinna mieć żadnych problemów z odszukaniem jej. 

przykład użycia argumentów:

java -jar Kalkulator.jar -a 4 5

Program powinien się uruchomić wyświetlić wiadomość powitalną oraz rozwiązać działanie podane w argumentach.

w repozytorium również znajduje się folder doc z dokumentacją Javadoc, którą przygotowałem. Było to moje pierwsze doświadczenie z własnoręcznym przygotowaniem dokumentacji mam nadzieje, że zrobiłem to poprawnie. 

ZADANIE REKRUTACYJNE - Program praktyk DTP
