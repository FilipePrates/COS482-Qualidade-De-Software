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
                    v-text="$t('calculaLifeStylerApp.customerServiceStartForm.serviceDate')"
                    for="customer-service-start-form-serviceDate"
                    >Service Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="customer-service-start-form-serviceDate"
                        v-model="$v.customerServiceProcess.customerService.serviceDate.$model"
                        name="serviceDate"
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
                      id="customer-service-start-form-serviceDate"
                      data-cy="serviceDate"
                      type="text"
                      class="form-control"
                      name="serviceDate"
                      :class="{
                        valid: !$v.customerServiceProcess.customerService.serviceDate.$invalid,
                        invalid: $v.customerServiceProcess.customerService.serviceDate.$invalid,
                      }"
                      v-model="$v.customerServiceProcess.customerService.serviceDate.$model"
                    />
                  </b-input-group>
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
