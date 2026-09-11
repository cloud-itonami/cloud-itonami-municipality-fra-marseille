(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Marseille (Ville de
  Marseille) -- a Wave 1b addition per ADR-2607171400 addendum 2, joining
  the cloud-itonami-municipality-* compliance-fact family of
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL Ville de Marseille PDF (served by the
  official subdomain mes-demarches.marseille.fr; www.marseille.fr itself
  answered direct fetches with an HTTP 403 maintenance page on
  2026-07-17) -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an id/url/number.

  Both entries below were verified on 2026-07-17 by downloading each
  source PDF and directly reading the PDF text via the Read tool: each
  title, arrete number and date stated here appears in the text of the
  cited PDF (title page and signature block). The signature blocks
  incidentally carry officials' names -- those were read only to locate
  the arrete number/date and are NOT stored anywhere in this catalog,
  consistent with this family's no-personal-names discipline.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"marseille"
   [{:ordinance/id "marseille.arrete-cadre-grues-a-tour-2025"
     :ordinance/title "Arrêté cadre portant réglementation de l'utilisation des grues à tour sur le territoire de la Ville de Marseille"
     :ordinance/municipality "marseille"
     :ordinance/country "FRA"
     :ordinance/kind :ordinance
     :ordinance/number "Arrêté N° 2025_01676_VDM, signé le 15/05/2025 (reçu en préfecture le 15/05/2025)"
     :ordinance/url "https://mes-demarches.marseille.fr/media/uploads/2025/05/20/arrete-municipal-n2025_01676_vdm-grue-a-tour.pdf"
     :ordinance/url-provenance :official-marseille-fr
     :ordinance/enacted-date "2025-05-15"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:construction-safety :public-safety}}
    {:ordinance/id "marseille.arrete-aires-pietonnes-bornes-automatiques-2019"
     :ordinance/title "Arrêté réglementant les conditions de circulation et de stationnement dans les aires piétonnes à accès par bornes automatiques de la commune de Marseille"
     :ordinance/municipality "marseille"
     :ordinance/country "FRA"
     :ordinance/kind :ordinance
     :ordinance/number "Arrêté N° P1902123, fait à Marseille le 26/11/2019, entrée en vigueur le 01/12/2019"
     :ordinance/url "https://mes-demarches.marseille.fr/media/uploads/2025/01/03/aires-pietonnes-arrete_bornes_automatiques_p1902123.pdf"
     :ordinance/url-provenance :official-marseille-fr
     :ordinance/enacted-date "2019-11-26"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:traffic :public-space}}]})

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
      :note (str "cloud-itonami-municipality-fra-marseille Wave 1b (ADR-2607171400 "
                 "addendum 2 / family ADR-2607141700): "
                 (count (get catalog "marseille")) " Marseille entries seeded "
                 "with official Ville de Marseille citations. Extend "
                 "`ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
