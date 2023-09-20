# Worttrainer
Willkommen beim Worttrainer! Dieses Projekt zielt darauf ab, einen Rechtschreibtrainer für Volksschulkinder zu entwickeln.

## Model
Die Klasse "ImageWordPair" repräsentiert Paare von Wörtern und dazugehörigen Bildern, die über URLs verfügbar sind.
Der Rechtschreibtrainer selbst ist als Klasse "SpellingTrainer" modelliert.
Der Trainer verwaltet eine Menge von Wort-Bild-Paaren, wobei zu Beginn kein Paar ausgewählt ist.
Es kann ein zufälliges Wort-Bild-Paar ausgewählt werden, und die Bild-URL kann abgerufen werden, um das zugehörige Wort zu erraten.
Statistiken über insgesamt, richtig und falsch geratene Wörter werden geführt (mit der Klasse "TrainerStatistics")

## View
Der Worttrainer verfügt über eine einfache grafische Oberfläche, die JOptionPane verwendet.
Beim Programmstart werden persistierte Daten geladen, oder ein neuer Trainer wird mit vordefinierten Wortpaaren erstellt.
Die Benutzerinteraktion erfolgt über JOptionPane, wobei die Statistik und das Bild angezeigt werden und der Benutzer das Wort eingeben kann.
Der aktuelle Zustand des Worttrainers wird am Ende persistiert.

## Persistierung
Die Anwendung ermöglicht die Speicherung einer Worttrainer-Session, einschließlich der verfügbaren Wort-Bild-Paare, des aktuellen ausgewählten Paares (falls vorhanden) und der Statistik.
Die Persistierung wird mithilfe von JSON realisiert.
Dadurch, dass ein Interface "IPersistable" definiert ist, kann die Persistierungsmethode leicht ausgetauscht werden.