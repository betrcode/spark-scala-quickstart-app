Spark Scala Quickstart Application
==================================

Created after following the quickstart guide at https://spark.apache.org/docs/latest/quick-start.html

The program will read The King James Bible and count how many times the specified set of words (arguments) are used in the text.

## Using
* Scala
* SBT
* Spark

## Purpose
A first taste of Spark.

## How to run from command line
$ `sbt "run god devil jesus christ mcdonalds"`
The words after `run` are the arguments to the program. Change as you please.

Example output:

```
Map(christ -> 574, jesus -> 973, devil -> 111, mcdonalds -> 0, god -> 4544)
```
