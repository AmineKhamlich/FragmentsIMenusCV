# Resum: Fragments i Menus

Aquest document resumeix els punts clau que hem implementat.

## 1. Estructura Bàsica d'un Fragment
Un fragment necessita dos mètodes principals:

### `onCreateView`
*   **Què fa?**: "Infla" (crea) la part visual (XML).
*   **Codi Clau**: `fragmentbinding = FragmentPrimerBinding.inflate(...)` i `return binding.root`.
*   **Alerta**: NO fer servir `setContentView` (això és només per a Activities!).

### `onViewCreated`
*   **Què fa?**: La vista ja existeix! Aquí posem la lògica.
*   **Codi Clau**: Assignar text als TextViews (`binding.tvNom.text = ...`) i llegir arguments.

## 2. Comunicació: Activity -> Fragment
Per passar dades, utilitzem un "paquet" anomenat `Bundle`.

### Pas 1: Enviar (MainActivity)
Creem el paquet i l'enviem al fragment.
```kotlin
val bundle = bundleOf(
    "LaMevaClau" to "ElValorQueVullEnviar"
)
// Enviem el paquet
replace(R.id.contenidor, ElMeuFragment().apply { arguments = bundle })
```

### Pas 2: Rebre (El Fragment)
Obrim el paquet dins de `onViewCreated`.
```kotlin
// La clau "LaMevaClau" ha de ser IDENTICA a la de dalt
val textRebut = arguments?.getString("LaMevaClau")
```

## 3. Errors Comuns a Evitar
*   **ViewBinding a onCreate**: Mai intentis accedir a elements de la vista (`binding.tv...`) dins de `onCreate`. Fes-ho sempre a `onViewCreated`.
*   **Claus diferents**: Si envies amb "Nom" i intentes llegir "nom" (minúscula), no funcionarà. Copia i enganxa les claus!

## 4. Repositori GitHub
El codi complet es troba aquí: [https://github.com/AmineKhamlich/FragmentsIMenusCV](https://github.com/AmineKhamlich/FragmentsIMenusCV)
