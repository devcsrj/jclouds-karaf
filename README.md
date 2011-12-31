# Karaf JClouds Integration

This project currently hosts a Karaf feature for easy installation of JClouds inside Apache Karaf.

Installation Instructions
-------------------------
On Karaf 2.2.0 or later:

1) Install JClouds AWS Modules
karaf@root> features:addurl mvn:org.jclouds.karaf/jclouds-karaf/1.2.2/xml/features

karaf@root> features:install jclouds-aws-s3

karaf@root> features:install jclouds-aws-ec2

2) Install Karaf Commands
karaf@root> features:install jclouds-commands


3) Create a sample blobstore service
karaf@root> config:edit  org.jclouds.blobstore-s3

karaf@root> config:propset provider aws-s3

karaf@root> config:propset identity XXXXXXXXX

karaf@root> config:propset credential XXXXXXXXX

karaf@root> config:update


4) Use the blobstore commands
karaf@root> jclouds:blobstore-write BUCKET_NAME BLOB_NAME payload

karaf@root> jclouds:blobstore-read BUCKET_NAME BLOB_NAME

And it will display the payload. This works well for String payloads, but for binary payloads the user can use the url to be used as input or output for the commands:

karaf@root> jclouds:blobstore-write BUCKET_NAME BLOB_NAME URL_POINTING_TO_THE_PAYLOAD.

karaf@root> jclouds:blobstore-read BUCKET_NAME BLOB_NAME LOCAL_FILE_TO_STORE_THE_BLOB.


5) Create a sample ec2 compute service
karaf@root> config:edit  org.jclouds.compute-ec2

karaf@root> config:propset provider aws-ec2

karaf@root> config:propset identity XXXXXXXXX

karaf@root> config:propset credential XXXXXXXXX

karaf@root> config:propset jclouds.ec2.ami-owners  XXXXXXXXX

karaf@root> config:update

6) Use the compute service commands
karaf@root> jclouds:node-create YOUR_IMAGE_ID YOUR_LOCATION_ID GROUPNAME

karaf@root> jclouds:node-list.

7) Code completion.

Most of the commands support tab completion, in order to help the user easily complete node ids, images, locations, blob containers etc.

Enjoy your new instance on EC2

## License

Copyright (C) 2009-2011 jclouds, Inc.

Licensed under the Apache License, Version 2.0
