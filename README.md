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
- destructuring
    - assign components of an instance into several variables - `val (name, age) = person`
- extension functions
    - enhance class functionality even if you have no control over the code
- operator overloading
    - useful for equality and comparisons (`==` `!=` and `<` `<=` `>` `>=`)
    - useful for math classes (`+` `-` `*` `/` `%` `!` `..` `++` `--` `+=` ...)
    - useful for containers and DSL (`()`, `[]`)
    - (please use in moderation)
- compact class declarations
    - constructor with properties as part of class declaration
    - classes are final per default (use `open` or `sealed`)
- enforced primary constructors
    - secondary constructor must end up calling the single primary constructor
- good handling of immutable vs. mutable states
    - language design is biased in favor of immutability
    - mutable and immutable collection classes
- improved generics
    - `in` and `out` instead of producer-extends and consumer-super
    - use `reified` to prevent type erasure in `inline` functions 
- language allows designing nice DSLs
    - generally less clutter (see all of the above)
    - lambda function with receiver
    - single lambda argument can be omitted 
    - infix functions
- ... many others ...


