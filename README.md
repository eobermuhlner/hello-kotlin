This is a playground for Kotlin development.


Best Kotlin features:
- properties instead of fields
    - no more getter/setter functions
    - property delegation
- null safe types
    - compiler enforces null safety
    - always know when you need to check
    - smart casting after checking for `null`
    - better operators: `?.` `!!.` `?:` 
- type inference
    - less boiler plate code
    - (please use in moderation)
- better function calls
    - default values
    - named arguments
    - last argument can be written outside `()` if lambda function
- extension functions
    - enhance class functionality even if you have no control over the code
- operator overloading
    - useful for equality and comparisons (`==` `!=` and `<` `<=` `>` `>=`)
    - useful for math classes (`+` `-` `*` `/`)
    - useful for containers and DSL (`()`, `[i]`)
    - (please use in moderation)
- compact class declarations
    - constructor with properties as part of class declaration
    - classes are final per default (use `open` or `sealed`)
- enforced primary constructors
    - secondary constructor must end up calling the single primary constructor
- good handling of immutable vs. mutable states
    - language design is biased in favor of immutability
    - mutable and immutable collection classes
- language allows designing nice DSLs
    - generally less clutter (see all of the above)
    - lambda function with receiver
    - single lambda argument can be omitted 
    - infix functions
- ... many others ...


