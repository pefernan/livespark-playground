{
  "id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701",
  "name": "User",
  "fields": [

      {
        "maxLength": 100,
        "placeHolder": "Name",
        "annotatedId": false,
        "code": "TextBox",
        "id": "field_399869484059281E11",
        "name": "user_name",
        "label": "Name",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "name",
        "standaloneClassName": "java.lang.String",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
      }
    ,
      {
        "maxLength": 100,
        "placeHolder": "Last Name",
        "annotatedId": false,
        "code": "TextBox",
        "id": "field_0836304030124905E11",
        "name": "user_lastName",
        "label": "Last Name",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "lastName",
        "standaloneClassName": "java.lang.String",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
      }
    ,
      {
        "placeHolder": "Birthday",
        "showTime": true,
        "annotatedId": false,
        "code": "DatePicker",
        "id": "field_939202328109672E11",
        "name": "user_birthday",
        "label": "Birthday",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "birthday",
        "standaloneClassName": "java.util.Date",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.datePicker.DatePickerFieldDefinition"
      }
    ,
      {
        "annotatedId": false,
        "code": "CheckBox",
        "id": "field_26248421812532E11",
        "name": "user_married",
        "label": "Married",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "married",
        "standaloneClassName": "java.lang.Boolean",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.checkBox.CheckBoxFieldDefinition"
      }
    ,
      {
        "nestedForm": "797a781f-7046-4162-95fc-09933ef7068b",
        "annotatedId": false,
        "code": "SubForm",
        "id": "field_422069810659575E11",
        "name": "user_address",
        "label": "Address",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "address",
        "standaloneClassName": "demo.client.shared.Address",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.relations.SubFormFieldDefinition"
      }
    ,
      {
        "creationForm": "797a781f-7046-4162-95fc-09933ef7068b",
        "editionForm": "797a781f-7046-4162-95fc-09933ef7068b",
        "columnMetas": [
          {
            "label": "Street Name",
            "property": "street"
          },
          {
            "label": "#",
            "property": "num"
          },
          {
            "label": "CP",
            "property": "cp"
          },
          {
            "label": "City",
            "property": "city"
          },
          {
            "label": "Country",
            "property": "country"
          }
        ],
        "annotatedId": false,
        "code": "MultipleSubForm",
        "id": "field_434690941363019E11",
        "name": "user_adresses",
        "label": "Other Adresses",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "user",
        "boundPropertyName": "adresses",
        "standaloneClassName": "demo.client.shared.Address",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.relations.MultipleSubFormFieldDefinition"
      }

  ],
  "dataHolders": [
    {
      "name": "user",
      "type": "demo.client.shared.User"
    }
  ],
  "layoutTemplate": {
    "version": 1,
    "name": "User",
    "layoutProperties": {},
    "rows": [
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_399869484059281E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_0836304030124905E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_939202328109672E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_26248421812532E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_422069810659575E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_434690941363019E11",
                  "form_id": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701"
                }
              }
            ]
          }
        ]
      }
    ]
  }
}
