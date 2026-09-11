(ns culture.facts
  "Regional-culture catalog for Marseille (Ville de Marseille) -- local
  dishes, protected products, beverages, festivals and heritage sites,
  piggybacked onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"marseille"
   [{:culture/id "marseille.dish.bouillabaisse"
     :culture/name "Bouillabaisse"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Traditional Provençal fish soup originating in the port city of Marseille, made with Mediterranean rockfish and served with bread and rouille; a 1980 charter by local restaurateurs standardized its authentic form."
     :culture/url "https://en.wikipedia.org/wiki/Bouillabaisse"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.dish.pieds-paquets"
     :culture/name "Pieds paquets"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Culinary specialty of Marseille and Sisteron consisting of sheep's feet and stuffed sheep's tripe stewed slowly in white wine and tomato sauce."
     :culture/url "https://en.wikipedia.org/wiki/Pieds_paquets"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.dish.aioli"
     :culture/name "Aioli"
     :culture/name-local "Aïoli"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Cold emulsion sauce of garlic and olive oil strongly associated with Provence, traditionally crushed in a mortar and pestle."
     :culture/url "https://en.wikipedia.org/wiki/Aioli"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.dish.navette-de-marseille"
     :culture/name "Navette de Marseille"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Traditional Marseille biscuit shaped like a small boat, prepared for Candlemas (la Chandeleur), when it replaces crêpes; linked by legend to the abbey of Saint-Victor."
     :culture/url "https://fr.wikipedia.org/wiki/Navette_de_Marseille"
     :culture/url-provenance :wikipedia-fr
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.beverage.pastis"
     :culture/name "Pastis"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :beverage
     :culture/summary "Anise-flavoured spirit and apéritif traditionally from France, first commercialized in 1932; particularly associated with the city of Marseille, where it is nicknamed pastaga."
     :culture/url "https://en.wikipedia.org/wiki/Pastis"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.product.savon-de-marseille"
     :culture/name "Marseille soap"
     :culture/name-local "Savon de Marseille"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :product
     :culture/summary "Traditional hard soap made from vegetable oils; soapmaking in Marseille is documented from about 1370, and its standards were formalized by royal regulation in 1688."
     :culture/url "https://en.wikipedia.org/wiki/Marseille_soap"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.festival.foire-aux-santons"
     :culture/name "Foire aux santons de Marseille"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :festival
     :culture/summary "Fair of Provençal nativity figurines (santons) held in Marseille since 1803, beginning the last Sunday of November; located on the Vieux-Port since 2018."
     :culture/url "https://fr.wikipedia.org/wiki/Foire_aux_santons"
     :culture/url-provenance :wikipedia-fr
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.heritage.notre-dame-de-la-garde"
     :culture/name "Notre-Dame de la Garde"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :heritage
     :culture/summary "Catholic basilica on a 149 m limestone outcropping above the Old Port, the best-known symbol of Marseille, known locally as la Bonne Mère; built from 1853 and consecrated in 1864."
     :culture/url "https://en.wikipedia.org/wiki/Notre-Dame_de_la_Garde"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "marseille.craft.santons"
     :culture/name "Santons of Provence"
     :culture/name-local "Santons de Provence"
     :culture/municipality "marseille"
     :culture/country "FRA"
     :culture/kind :craft
     :culture/summary "Small hand-painted terracotta nativity figurines, a traditional product of Provence whose manufacture is centred on Marseille, Aix-en-Provence, Arles and Aubagne."
     :culture/url "https://en.wikipedia.org/wiki/Santon_(figurine)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-fra-marseille culture catalog "
                 "(ADR-2607171400): " (count (get catalog "marseille"))
                 " Marseille entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
