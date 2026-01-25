<?php
/**
 * Created by PhpStorm.
 * User: s.kemper
 * Date: 29.03.2022
 * Time: 22:05
 *
 * This class does a lot of things... but has no productive purpose.
 * The only purpose of this class is to teach the basic functions
 * of PHP and how to use them.
 */

class MyFancyClass
{
    public function shortString($text, $length, $ending = '...') {
        // Prüfung aus Testfall: assertFalse bei $textEmpty mit zu langer $endingLong
        if (strlen($ending) > $length) {
            return false;
        }

        // Prüfung: Wenn Text bereits kurz genug ist, nichts tun
        if (strlen($text) <= $length) {
            return $text;
        }

        // Berechnung der Schnittlänge
        $cutLength = $length - strlen($ending);
        
        // Text kürzen und Endung anhängen
        return substr($text, 0, $cutLength) . $ending;
    }

    public function calcAverage($values) {
        if (empty($values)) {
            return 0;
        }

        // Prüfung auf ungültige Werte (Strings die keine Zahlen sind)
        foreach ($values as $value) {
            if (!is_numeric($value)) {
                return false;
            }
        }

        return array_sum($values) / count($values);
    }

    public function getOpposite($value, $delimiter = ',') {
        if (is_array($value)) {
            return implode($delimiter, $value);
        } elseif (is_string($value)) {
            return explode($delimiter, $value);
        }
        
        return false;
    }
}
