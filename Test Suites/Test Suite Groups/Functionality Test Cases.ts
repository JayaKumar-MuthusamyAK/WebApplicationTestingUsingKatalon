<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Functionality Test Cases</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>a2cc6f66-db1a-41da-bae5-6ce858ecdc27</testSuiteGuid>
   <testCaseLink>
      <guid>d9023baa-3b37-4687-807c-2c13c01e9476</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/1. OnboardingTestcase/TC_001_ValidLogin</testCaseId>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>d246922a-b415-4895-b9df-49af5eac94f8</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>7b7bc38d-9056-4fcc-bd7c-16eba2a7fd86</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/1. OnboardingTestcase/TC_002_InvalidLogin</testCaseId>
      <testDataLink>
         <combinationType>MANY</combinationType>
         <id>cfa52b86-16a3-4328-9712-a4d98ac5a3be</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/TestDataFile</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>cfa52b86-16a3-4328-9712-a4d98ac5a3be</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Email</value>
         <variableId>7bcdd9ce-c315-4ade-8d57-2298d9c07f88</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>cfa52b86-16a3-4328-9712-a4d98ac5a3be</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>c9a42719-4d93-4e4a-8710-792fb821ecfd</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>cfa52b86-16a3-4328-9712-a4d98ac5a3be</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Message</value>
         <variableId>66756965-961f-478a-ae89-d6208aef1e92</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>45b03fbc-9424-461e-9d16-b3500287c159</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/2. CommonTestcase/TC_003_CookiesValidation</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>ab7f6bf0-48b1-43af-bc79-89966f300fae</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/2. CommonTestcase/TC_004_BrokenLinkChecker</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>26f0b3e2-f344-4fad-95db-ddd60906ac55</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/BrokenLinksUrlTestData</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>26f0b3e2-f344-4fad-95db-ddd60906ac55</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Urls</value>
         <variableId>2e232ff6-6fb3-4a1d-ab09-4867975a6beb</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
