*** Settings ***

Library     HttpLibrary.HTTP



*** Test Cases ***

Test Cloud-work Logging

    Create HTTP Context    172.29.4.47:30010

    GET      /msg

    ${body}    Get Response Body

    log        ${body}



