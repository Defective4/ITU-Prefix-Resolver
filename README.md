# ITU-Prefix-Resolver

ITU Prefix Resolver allows you to resolve country names from amateur callsigns.

# Installation
Include this in your `<dependencies>` section of `pom.xml`:
```xml
<dependency>
	<groupId>io.github.defective4.ham</groupId>
	<artifactId>itu-prefix-resolver</artifactId>
	<version>1.0</version>
</dependency>
```

# Usage
Example usage:
```java
String callsign = "SP9ABC";
String country = CountryResolver.resolve(callsign);
System.out.println(country); // Poland
```