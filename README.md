# Read Me

The original idea is from  
https://medium.com/@mbanaee61/comprehensive-overview-of-http-caching-mechanisms-3381c7041682

# Cache-Control

The Cache-Control header provides directives to specify how, when, and for how long resources should be cached.

# ETag

An ETag is a unique identifier for a specific version of a resource. It helps clients determine whether their cached
version is still valid.

# Last-Modified

The Last-Modified header indicates the date and time when a resource was last modified.

# Vary

The Vary header tells caches which request headers to consider when deciding whether a cached response can be used.

# Expires

The Expires header provides an absolute date and time after which a response is considered stale.

# If-None-Match

The If-None-Match header allows the client to make conditional requests by specifying an ETag.

# If-Modified-Since

The If-Modified-Since header allows the client to make conditional requests based on the Last-Modified date.

# Cache Revalidation

Cache revalidation mechanisms like must-revalidate and conditional requests ensure that caches validate stale responses
with the origin server before using them.

# Content-Disposition

While not a caching mechanism per se, the Content-Disposition header can influence how browsers handle certain
resources, including whether they should be cached.

