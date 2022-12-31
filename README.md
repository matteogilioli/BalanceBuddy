# GestioneBilancio
Tenere sotto controllo le proprie entrate e le proprie spese è diventata una necessità non solo delle aziende e degli enti commerciali, 
ma anche delle famiglie o delle associazioni di volontariato.
Il presente progetto si propone di descrivere e sviluppare una applicazione Java che abbia le seguenti funzionalità:
- Gestione del bilancio
- Salvataggio e caricamento del bilancio
- Ricerca di informazioni nel bilancio
- Esportazione del bilancio
- Stampa del bilancio

## Gestione del bilancio
L'applicazione permette di gestire un bilancio personale, aggiungendo, modificando e cancellando voci di entrate e spese. 
La data di default per le nuove voci è quella odierna, ma può essere modificata dall'utente. 
Le informazioni vengono mostrate in una tabella, con la possibilità di visualizzare i dati di un singolo giorno, di una settimana, di un mese o di un anno. 
La tabella mostra anche la somma finale delle entrate e delle spese.

## Salvataggio e caricamento del bilancio
L’utente ha la possibilità di salvare il bilancio su un file, specificandone il nome, e di ricaricare il bilancio specificando il nome del file salvato in precedenza.

## Ricerca di informazioni nel bilancio
L’utente ha la possibilità di effettuare delle ricerche nel bilancio. La ricerca si basa su testo libero che può essere una parte del testo contenuto in una voce.
La ricerca evidenzia la prima cella/riga che contiene il testo cercato; l’applicazione permette all’utente di continuare la ricerca per evidenziare man mano le celle/righe successive che rispondono ai requisiti.

## Esportazione del bilancio
L’utente ha la possibilità di esportare il bilancio in diversi formati:
- formato CSV (Comma Separated Values), in cui ogni voce è rappresentata da una riga in un file, e ogni elemento della voce è separato da una virgola ( , )
- formato testuale, in cui ogni voce è rappresentata da una riga in un file, e ogni elemento della voce è separato da un separatore (tabulazione)

## Stampa del bilancio
L’utente ha la possibilità di stampare il bilancio attraverso una stampante configurata dal sistema operativo.
