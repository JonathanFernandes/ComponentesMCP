# Vibe Coding Tool Guideline

## Kotlin + Jetpack Compose • Allos Design System

## Core Principle — Design System First

Todo componente deve ser construído a partir do Design System como fonte única de verdade.

### Ordem obrigatória

1. Tokens do Design System
2. Componentes existentes
3. Composable novo
4. Fallback técnico (último recurso)

---

## Token APIs Oficiais

### Cores

Usar sempre:
- `AllosTheme.colors.*`

Nunca usar:
- `Color(0x...)`
- `#HEX`
- `Color.White / Black / Gray`

### Tipografia

Usar:
- `AllosTheme.typography.*`
- wrappers do DS (`Heading5`, `BodyMedium` etc.)

Nunca:
- `TextStyle` manual
- `fontSize` literal

### Espaçamentos e Layout

Usar:
- `AllosDimensions.Padding.*`
- `AllosDimensions.Gap.*`
- `AllosDimensions.Spacing.*`

Nunca:
- `padding(16.dp)`
- `Spacer(8.dp)`

---

## Spacing Rules

### Padding
Espaçamento interno do container.

### Gap
Espaçamento entre elementos em `Row`/`Column`/`Lazy`.

### Spacing
Unidade base quando não for padding/gap.

### Margin
Compose não possui margin nativo. Preferir:
- `padding` no container pai
- `Spacer`
- `Arrangement.spacedBy()`

---

## Negative Tokens Policy

Usar apenas quando:
- sobreposição intencional
- compensação de layout validada

Nunca:
- como hack visual

---

## Component Tokens

### Alturas
- `ButtonHeight`
- `InputFieldHeight`
- `Badge`

### Radius
- `BorderRadius.*`

### Stroke
- `BorderStroke.*`

### Elevation
- `Elevation.*`

Nunca usar `dp` literal.

---

## Compose Architecture Rules

### Stateless first
Componentes recebem state por parâmetro.

### Unidirectional data flow
Nada de lógica dentro do composable.

### Proibido
- acessar `ViewModel` dentro do componente

---

## Layout Rules

Usar:
- `Column`
- `Row`
- `Box`
- `LazyColumn` / `LazyRow`

Evitar:
- nested layouts desnecessários
- `weight` sem necessidade

---

## Preview Rules

Todo componente deve ter:
- Preview default
- Preview com variações
- Preview edge cases

---

## Performance Rules

- evitar recomposition desnecessária
- usar `remember` corretamente
- usar `keys` em lazy lists

---

## Component Structure Pattern

```kotlin
@Composable
fun ComponentName(
    modifier: Modifier = Modifier,
    ...
) {
    AllosTheme {
        ...
    }
}
```

---

## Anti-patterns

❌ Hex  
❌ dp literal  
❌ TextStyle manual  
❌ criar tokens dentro do componente

---

## Goal

Garantir:
- consistência visual
- escala do produto
- reutilização
- automação por AI
- integração Design → Code
