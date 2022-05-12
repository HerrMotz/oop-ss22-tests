# Übungsserie 1 Aufgabe 1 (Fehlersuche bei Arrays und Schleifen)

## 1.a)
Geben Sie an, was in der Zeile 5 ausgegeben wird!

```java
int [] a={1,2,3,4,-1,-2,-3,-4}; //#1
int [] b=a; //#2
//#3
a[2]=17; //#4
System.out.println(java.util.Arrays.toString(b)); //#5
```

Ausgabe: [1, 2, 17, 4, -1, -2, -3, -4]

## 1.b) 

```java
// Teil A //#6
// Summe aller Werte in a berechnen //#7
int sum=0; //#8
        for (int i=0;i<=a.length;i++) //#9
        sum+=a[i]; //#10
```

Fehler in Zeile `9`: `java.lang.ArrayIndexOutOfBoundsException`

Richtig: `for (int i=0;i<a.length;i++)`

```java
// Teil B //#11
// Ausgabe aller Werte //#12
int k=0; //#13
for (int i=1;i<=a.length;i++) //#14
System.out.println(i + ": " + a[k++]); //#15
```

Fehler in Zeile ` `: `Kein Fehler`

```java
// Teil C //#16
// Mittelwert von je drei aufeinanderfolgenden Werten berechnen //#17
// und im Array m ablegen //#18
int [] m=new int[a.length-2]; //#19
for (int i=1; i < a.length-1; i++) //#20
{ //#21
    int val=(a[i-1] + a[i] + a[i+1]); //#22
    m[i]=val / 3; //#23
}
```

Fehler in Zeile `23`: `ArrayOutOfBoundsException: der höchste Index für "m" ist a.length-3`

Richtig: `m[i-1] = val / 3;`

```java
// Teil D //#25
// Maximum berechnen //#26
int max=0; //#27
for (int i=0; i < a.length; i++) //#28
{ //#29
    if (a[i]>max) //#30
    max=a[i]; //#31
} //#32
```

Fehler in Zeile `30`: `Das gesuchte Maximum könnte negativ sein. Der Vergleich mit 0 wird dann falsch ausgewertet und 0 zurückgegeben.`

Richtig: `int max = Integer.MIN_VALUE`

oder auch:

Fehler in Zeile `27`: `dito`

Richtig: `int max = a[0]`
