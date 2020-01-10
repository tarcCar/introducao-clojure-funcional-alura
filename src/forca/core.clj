(ns forca.core
  (:gen-class))

(def total-de-vidas 6)
(def palavra-secreta "mel")

(defn perdeu [] (print "você perdeu"))
(defn ganhou [] (print "você ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

(defn acertou-palavra-toda? [palavra acertos]  (empty? (letras-faltantes palavra, acertos)) )

(defn acertou? [chute palavra] (.contains palavra chute))

(defn le-letra! [] (read-line))

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas " vidas)
  (doseq [letra (seq palavra)] (if (contains? acertos (str letra))
                                 (print letra " ")
                                 (print "_" " ")))
  (println))

(defn jogo [vidas palavra acertos]
  (imprime-forca vidas, palavra acertos)
  (cond
    (= vidas 0) (perdeu)
      (acertou-palavra-toda? palavra acertos) (ganhou)
      :else
        (let [chute (le-letra!)]
          (if (acertou? chute palavra)
            (do
              (println "Acertou a letra!")
              (recur vidas palavra (conj acertos chute)))
            (do
              (println "Errou a letra! Perdeu vida!")
              (recur (dec vidas) palavra acertos))))))


(defn comeca-o-jogo [] (jogo total-de-vidas palavra-secreta #{}))

(defn -main
  [& args]
  (comeca-o-jogo))
