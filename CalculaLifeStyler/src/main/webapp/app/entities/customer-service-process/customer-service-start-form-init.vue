<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="calculaLifeStylerApp.customerServiceStartForm.home.createOrEditLabel"
          data-cy="CustomerServiceStartFormCreateUpdateHeading"
          v-text="$t('calculaLifeStylerApp.customerServiceStartForm.home.createOrEditLabel')"
        >
          Create or edit a CustomerServiceStartForm
        </h2>
        <div v-if="customerServiceProcess.processInstance">
          <akip-show-process-definition :processDefinition="customerServiceProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="customerServiceProcess.customerService">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('calculaLifeStylerApp.customerServiceStartForm.name')"
                    for="customer-service-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="customer-service-start-form-name"
                    data-cy="name"
                    :class="{
                      valid: !$v.customerServiceProcess.customerService.name.$invalid,
                      invalid: $v.customerServiceProcess.customerService.name.$invalid,
                    }"
                    v-model="$v.customerServiceProcess.customerService.name.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('calculaLifeStylerApp.customerServiceStartForm.startDate')"
                    for="customer-service-start-form-startDate"
                    >Start Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="customer-service-start-form-startDate"
                        v-model="$v.customerServiceProcess.customerService.startDate.$model"
                        name="startDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="customer-service-start-form-startDate"
                      data-cy="startDate"
                      type="text"
                      class="form-control"
                      name="startDate"
                      :class="{
                        valid: !$v.customerServiceProcess.customerService.startDate.$invalid,
                        invalid: $v.customerServiceProcess.customerService.startDate.$invalid,
                      }"
                      v-model="$v.customerServiceProcess.customerService.startDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('calculaLifeStylerApp.customerServiceStartForm.customerName')"
                    for="customer-service-start-form-customerName"
                    >Customer Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="customerName"
                    id="customer-service-start-form-customerName"
                    data-cy="customerName"
                    :class="{
                      valid: !$v.customerServiceProcess.customerService.customerName.$invalid,
                      invalid: $v.customerServiceProcess.customerService.customerName.$invalid,
                    }"
                    v-model="$v.customerServiceProcess.customerService.customerName.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('calculaLifeStylerApp.customerServiceStartForm.employeeName')"
                    for="customer-service-start-form-employeeName"
                    >Employee Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="employeeName"
                    id="customer-service-start-form-employeeName"
                    data-cy="employeeName"
                    :class="{
                      valid: !$v.customerServiceProcess.customerService.employeeName.$invalid,
                      invalid: $v.customerServiceProcess.customerService.employeeName.$invalid,
                    }"
                    v-model="$v.customerServiceProcess.customerService.employeeName.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.customerServiceProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./customer-service-start-form-init.component.ts"></script>
