# Karaf JClouds Integration

This project currently hosts a Karaf feature for easy installation of JClouds inside Apache Karaf.

Installation Instructions
-------------------------
On Karaf 2.2.0 or later:

1) Install JClouds AWS S3 Module
karaf@root> feature:addurl mvn:org.jclouds/karaf/1.0/xml/features
karaf@root> feature:install jclouds-aws-s3

2) Install the S3 Reader Sample

Add org.jclouds.samples.s3.reader.cfg with the following properties under ${karaf.home}/etc or create it via command line:

karaf@root> config:edit org.jclouds.samples.s3.reader
karaf@root> config:edit org.jclouds.samples.s3.reader
karaf@root> config:propset ACCESS_KEY_ID XXXXXXXXX
karaf@root> config:propset SECRET_KEY XXXXXXXXX
karaf@root> config:propset BLOB_NAME <some blobname>
karaf@root> config:propset BUCKET <some bucket name>
karaf@root> config:update 
karaf@root> osgi:install -s mvn:org.jclouds.karaf.sample/s3-reader/1.0

The sample is basic it will just display the content of the blob to the standard output.

## License

Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>

Licensed under the Apache License, Version 2.0
